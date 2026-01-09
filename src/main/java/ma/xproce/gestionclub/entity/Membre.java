package ma.xproce.gestionclub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "membres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;

    @Column(nullable = false)
    private String niveau; // L1, L2, L3, M1, M2

    @Column(nullable = false)
    private String filiere;

    private LocalDate dateInscription;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
}
