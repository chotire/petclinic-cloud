package petclinic.veterinarian.entity;

import lombok.*;
import petclinic.service.jpa.BaseAuditEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class MedicalReport extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEDICAL_REPORT_ID")
    private Integer id;

    @Column
    private String diagnosis;

    @Column
    private int veterinarianId;

    @Column
    private int petId;
}
