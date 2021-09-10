package petclinic.veterinarian.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import petclinic.service.jpa.BaseAuditEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Specialty extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPECIALTY_ID")
    private Integer id;

    @Column(length = 80)
    private String name;
}
