package petclinic.veterinarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petclinic.veterinarian.entity.MedicalReport;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
}
