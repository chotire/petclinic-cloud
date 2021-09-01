package petclinic.veterinarian.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import petclinic.veterinarian.entity.Veterinarian;
import petclinic.veterinarian.repository.VeterinarianRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
class VeterinarianController {
    private final VeterinarianRepository repository;

    @Value("${application.version}")
    private String version;

    @Value("${application.id:'ddd'}")
    private String id;

    @GetMapping("/veterinarians")
    List<Veterinarian> getVeterinarians() {
        System.out.println("version = " + version);
        System.out.println("id = " + id);
        return repository.findAll();
    }
}
