package petclinic.customer.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import petclinic.customer.entity.Pet;
import petclinic.customer.entity.PetType;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PetRequest {
    private int id;

    private LocalDate birthDate;

    @Size(min = 1)
    private String name;

    private PetType type;

    public Pet toEntity() {
        return Pet.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .type(type)
                .build();
    }
}
