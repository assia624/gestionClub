package ma.xproce.gestionclub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClubDTO {
    private Long id;

    @NotBlank(message = "Le nom du club est obligatoire")
    private String nom;

    private String description;

    @NotBlank(message = "Le président est obligatoire")
    private String president;

    @NotNull(message = "La date de création est obligatoire")
    private LocalDate dateCreation;

    private Integer nombreMembres;

    @NotBlank(message = "La catégorie est obligatoire")
    private String categorie;
}
