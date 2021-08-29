package petclinic.customer.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petclinic.customer.entity.Pet;
import petclinic.customer.entity.PetType;
import petclinic.customer.service.PetService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@Slf4j
class PetController {
    private final PetService petService;

    @GetMapping("/pet-types")
    List<PetType> getPetTypes() {
        List<PetType> petTypes = Stream.of(PetType.values())
                .sorted(Comparator.comparing(PetType::getName))
                .collect(Collectors.toList());
        return petTypes;
    }

    @PostMapping("/owners/{ownerId}/pets")
    @ResponseStatus(HttpStatus.CREATED)
    Pet add(@PathVariable("ownerId") int ownerId, @RequestBody PetRequest petRequest) {
        return petService.add(ownerId, petRequest);
    }

    @PutMapping("/owners/*/pets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable int id, @RequestBody PetRequest petRequest) {
        petRequest.setId(id);
        petService.update(petRequest);
    }
}
