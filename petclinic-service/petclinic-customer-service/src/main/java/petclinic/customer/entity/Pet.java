package petclinic.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PET_ID")
    private Integer id;

    @Column(length = 30)
    private String name;

    private LocalDate birthDate;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private PetType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    @JsonIgnore
    private Owner owner;

    public void setOwner(Owner owner) {
        this.owner = owner;
        this.owner.getPets().add(this);
    }

    public void update(String name, LocalDate birthDate, PetType type) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("birthDate", this.getBirthDate())
                .append("type", this.getType().getName())
                .append("ownerFirstname", this.getOwner().getFirstName())
                .append("ownerLastname", this.getOwner().getLastName())
                .toString();
    }
}
