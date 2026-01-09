package ma.xproce.gestionclub.service.impl;

import ma.xproce.gestionclub.dto.ClubDTO;
import ma.xproce.gestionclub.entity.Club;
import ma.xproce.gestionclub.repository.ClubRepository;
import ma.xproce.gestionclub.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<ClubDTO> getAllClubs() {
        return clubRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClubDTO getClubById(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club non trouvé avec l'ID : " + id));
        return convertToDTO(club);
    }

    @Override
    public ClubDTO saveClub(ClubDTO clubDTO) {
        Club club = convertToEntity(clubDTO);
        Club savedClub = clubRepository.save(club);
        return convertToDTO(savedClub);
    }

    @Override
    public void deleteClub(Long id) {
        if (!clubRepository.existsById(id)) {
            throw new RuntimeException("Club non trouvé avec l'ID : " + id);
        }
        clubRepository.deleteById(id);
    }

    @Override
    public List<ClubDTO> getClubsByCategorie(String categorie) {
        return clubRepository.findByCategorie(categorie).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Méthodes privées de conversion
    private ClubDTO convertToDTO(Club club) {
        return new ClubDTO(
                club.getId(),
                club.getNom(),
                club.getDescription(),
                club.getPresident(),
                club.getDateCreation(),
                club.getNombreMembres(),
                club.getCategorie()
        );
    }

    private Club convertToEntity(ClubDTO dto) {
        Club club = new Club();
        club.setId(dto.getId());
        club.setNom(dto.getNom());
        club.setDescription(dto.getDescription());
        club.setPresident(dto.getPresident());
        club.setDateCreation(dto.getDateCreation());
        club.setNombreMembres(dto.getNombreMembres());
        club.setCategorie(dto.getCategorie());
        return club;
    }
}

