package ma.xproce.gestionclub.repository;

import ma.xproce.gestionclub.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> findByCategorie(String categorie);
    List<Club> findByNomContainingIgnoreCase(String nom);
}