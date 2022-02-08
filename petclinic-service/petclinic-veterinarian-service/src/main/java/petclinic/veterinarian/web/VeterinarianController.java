package petclinic.veterinarian.web;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import petclinic.veterinarian.entity.Veterinarian;
import petclinic.veterinarian.repository.VeterinarianRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Timed("petclinic.veterinarian")
class VeterinarianController {
    private final VeterinarianRepository repository;

    @GetMapping("/veterinarians")
    List<Veterinarian> getVeterinarians() {
        return repository.findAll();
    }

    @GetMapping("/veterinarians/{id}")
    Veterinarian getVeterinarian(@PathVariable Integer id) throws Exception {
        Veterinarian vet = repository.getById(id);
        vet.getSpecialties().forEach(specialty -> System.out.println("specialty.getId() = " + specialty.getId()));
        return vet;
    }
}
