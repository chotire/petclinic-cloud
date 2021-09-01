package petclinic.veterinarian.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VETERINARIAN_ID")
    private Integer id;

    @Column(length = 30)
    @NotEmpty
    private String firstName;

    @Column(length = 30)
    @NotEmpty
    private String lastName;

    @ManyToMany
    @JoinTable(name = "VETERINARIAN_SPECIALTY", joinColumns = @JoinColumn(name = "VETERINARIAN_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPECIALTY_ID"))
    @OrderBy("NAME ASC")
    private List<Specialty> specialties = new ArrayList<>();
}
