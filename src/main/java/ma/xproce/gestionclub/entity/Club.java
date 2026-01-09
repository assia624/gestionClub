package ma.xproce.gestionclub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clubs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String president;

    private LocalDate dateCreation;

    private Integer nombreMembres;

    @Column(nullable = false)
    private String categorie; // Sport, Culture, Science, Art, etc.

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membre> membres = new ArrayList<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evenement> evenements = new ArrayList<>();
}