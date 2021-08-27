package petclinic.visit.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import petclinic.visit.entity.Visit;
import petclinic.visit.repository.VisitRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
//@Timed("petclinic.visit")
@Slf4j
class VisitController {
    private final VisitRepository repository;

    @Transactional
    @PostMapping("owners/*/pets/{petId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    Visit create(@Valid @RequestBody Visit visit, @PathVariable("petId") int petId) {
        visit.setPetId(petId);
        log.info("Saving visit {}", visit);
        return repository.save(visit);
    }

    @GetMapping("owners/*/pets/{petId}/visits")
    List<Visit> visits(@PathVariable("petId") int petId) {
        return repository.findByPetId(petId);
    }

//    @GetMapping("pets/visits")
//    Visits visitsMultiGet(@RequestParam("petId") List<Integer> petIds) {
//        final List<Visit> byPetIdIn = repository.findByPetIdIn(petIds);
//        return new Visits(byPetIdIn);
//    }
}
