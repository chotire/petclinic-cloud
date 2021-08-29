package petclinic.veterinarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petclinic.veterinarian.entity.Veterinarian;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {
}
