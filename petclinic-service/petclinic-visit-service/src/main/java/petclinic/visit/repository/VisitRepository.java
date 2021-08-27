package petclinic.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petclinic.visit.entity.Visit;

import java.util.Collection;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findByPetId(int petId);

    List<Visit> findByPetIdIn(Collection<Integer> petIds);
}
