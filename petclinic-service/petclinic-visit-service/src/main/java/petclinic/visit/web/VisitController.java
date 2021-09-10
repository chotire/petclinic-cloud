package petclinic.visit.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import petclinic.visit.client.VeterinarianResponse;
import petclinic.visit.client.VeterinarianServiceClient;
import petclinic.visit.entity.Visit;
import petclinic.visit.repository.VisitRepository;
import petclinic.visit.service.KafkaProducer;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
//@Timed("petclinic.visit")
@Slf4j
class VisitController {
    private final VisitRepository repository;
    private final KafkaProducer kafkaProducer;
    private final VeterinarianServiceClient veterinarianClient;
//    private final CircuitBreakerFactory circuitBreakerFactory;

    @Transactional
    @PostMapping("owners/*/pets/{petId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    Visit create(@Valid @RequestBody Visit visit, @PathVariable("petId") int petId) throws JsonProcessingException {
        visit.setPetId(petId);
        log.info("Saving visit {}", visit);

        repository.save(visit);
        kafkaProducer.send("petclinic-visit-topic", visit);
        return visit;
    }

    @GetMapping("owners/*/pets/{petId}/visits")
    List<VisitResponse> visits(@PathVariable("petId") int petId) {
        List<Visit> visits = repository.findByPetId(petId);
        return visits.stream()
                .map(visit -> {
//                    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
//                    VeterinarianResponse veterinarian = circuitBreaker.run(
//                            () -> veterinarianClient.getVeterinarian(visit.getVeterinarianId()),
//                            throwable -> new VeterinarianResponse());

                    VeterinarianResponse veterinarian = veterinarianClient.getVeterinarian(visit.getVeterinarianId());
                    return VisitResponse.builder()
                            .id(visit.getId())
                            .date(visit.getDate())
                            .description(visit.getDescription())
                            .petId(visit.getPetId())
                            .veterinarian(
                                VisitResponse.Veterinarian.builder()
                                        .id(veterinarian.getId())
                                        .firstName(veterinarian.getFirstName())
                                        .lastName(veterinarian.getLastName())
                                        .build()
                            )
                            .build();
                })
                .collect(Collectors.toList());
    }

//    @GetMapping("pets/visits")
//    Visits visitsMultiGet(@RequestParam("petId") List<Integer> petIds) {
//        final List<Visit> byPetIdIn = repository.findByPetIdIn(petIds);
//        return new Visits(byPetIdIn);
//    }
}
