package petclinic.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petclinic.customer.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}