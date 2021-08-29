package petclinic.customer.entity;

import lombok.*;
import org.springframework.core.style.ToStringCreator;
import petclinic.service.jpa.BaseAuditEntity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Owner extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OWNER_ID")
    private Integer id;

    @Column(length = 30)
    @NotEmpty
    private String firstName;

    @Column(length = 30)
    @NotEmpty
    private String lastName;

    @Column(length = 255)
    @NotEmpty
    private String address;

    @Column(length = 80)
    @NotEmpty
    private String city;

    @Column(length = 20)
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Pet> pets = new ArrayList<>();

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName())
                .append("address", this.address)
                .append("city", this.city)
                .append("telephone", this.telephone)
                .toString();
    }
}
