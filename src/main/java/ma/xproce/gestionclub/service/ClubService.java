package ma.xproce.gestionclub.service;

import ma.xproce.gestionclub.dto.ClubDTO;
import java.util.List;

public interface ClubService {
    List<ClubDTO> getAllClubs();
    ClubDTO getClubById(Long id);
    ClubDTO saveClub(ClubDTO clubDTO);
    void deleteClub(Long id);
    List<ClubDTO> getClubsByCategorie(String categorie);
}