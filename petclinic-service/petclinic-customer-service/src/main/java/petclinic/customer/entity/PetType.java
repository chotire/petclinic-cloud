package petclinic.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PetType {
    CAT("CAT", "cat"),
    DOG("DOG", "dog"),
    LIZARD("LIZARD", "lizard"),
    SNAKE("SNAKE", "snake"),
    BIRD("BIRD", "bird"),
    HAMSTER("HAMSTER", "hamster");

    private final String id;
    private final String name;
}
