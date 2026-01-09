package ma.xproce.gestionclub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembreDTO {
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Email invalide")
    private String email;

    private String telephone;

    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;

    @NotBlank(message = "La filière est obligatoire")
    private String filiere;

    @NotNull(message = "La date d'inscription est obligatoire")
    private LocalDate dateInscription;

    @NotNull(message = "Le club est obligatoire")
    private Long clubId;

    private String clubNom;
}

