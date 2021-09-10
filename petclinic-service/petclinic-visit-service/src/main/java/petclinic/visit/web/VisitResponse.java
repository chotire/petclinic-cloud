package petclinic.visit.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class VisitResponse {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String description;

    private int petId;

    private Veterinarian veterinarian;

    @Getter
    @Builder
    static class Veterinarian {
        private Integer id;
        private String firstName;
        private String lastName;
    }
}
