package ma.xproce.gestionclub.repository;

import ma.xproce.gestionclub.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {
    List<Membre> findByClubId(Long clubId);
    List<Membre> findByNiveau(String niveau);
}
