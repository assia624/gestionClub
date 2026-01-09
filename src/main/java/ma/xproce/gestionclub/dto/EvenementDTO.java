package ma.xproce.gestionclub.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvenementDTO {
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    private String description;

    @NotNull(message = "La date de début est obligatoire")
    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    @NotBlank(message = "Le lieu est obligatoire")
    private String lieu;

    private Integer capacite;

    @NotNull(message = "Le club est obligatoire")
    private Long clubId;

    private String clubNom;
}
