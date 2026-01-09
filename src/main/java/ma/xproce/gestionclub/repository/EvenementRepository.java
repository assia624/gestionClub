package ma.xproce.gestionclub.repository;

import ma.xproce.gestionclub.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    List<Evenement> findByClubId(Long clubId);
    List<Evenement> findByDateDebutAfter(LocalDateTime date);
}