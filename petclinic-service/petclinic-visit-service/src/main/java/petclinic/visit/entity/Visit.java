package petclinic.visit.entity;

import lombok.*;
import petclinic.service.jpa.BaseAuditEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Builder(builderMethodName = "visit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
public class Visit extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VISIT_ID")
    private Integer id;

    @Column(name = "VISIT_DATE")
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @Size(max = 8192)
    @Column(length = 8192)
    private String description;

    @Column
    @Setter
    private int petId;

    @Column
    private int veterinarianId;
}
