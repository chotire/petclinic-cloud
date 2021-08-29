package petclinic.veterinarian.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import petclinic.veterinarian.entity.Veterinarian;
import petclinic.veterinarian.repository.VeterinarianRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
class VeterinarianController {
    private final VeterinarianRepository repository;

    @GetMapping("/veterinarians")
    List<Veterinarian> getVeterinarians() {
        return repository.findAll();
    }
}
