package petclinic.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petclinic.customer.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
