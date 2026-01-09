package ma.xproce.gestionclub.service.impl;

import ma.xproce.gestionclub.dto.MembreDTO;
import ma.xproce.gestionclub.entity.Club;
import ma.xproce.gestionclub.entity.Membre;
import ma.xproce.gestionclub.repository.ClubRepository;
import ma.xproce.gestionclub.repository.MembreRepository;
import ma.xproce.gestionclub.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembreServiceImpl implements MembreService {

    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<MembreDTO> getAllMembres() {
        return membreRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MembreDTO getMembreById(Long id) {
        Membre membre = membreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID : " + id));
        return convertToDTO(membre);
    }

    @Override
    public MembreDTO saveMembre(MembreDTO membreDTO) {
        Membre membre = convertToEntity(membreDTO);
        Membre savedMembre = membreRepository.save(membre);
        return convertToDTO(savedMembre);
    }

    @Override
    public void deleteMembre(Long id) {
        if (!membreRepository.existsById(id)) {
            throw new RuntimeException("Membre non trouvé avec l'ID : " + id);
        }
        membreRepository.deleteById(id);
    }

    @Override
    public List<MembreDTO> getMembresByClub(Long clubId) {
        return membreRepository.findByClubId(clubId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Méthodes privées de conversion
    private MembreDTO convertToDTO(Membre membre) {
        MembreDTO dto = new MembreDTO();
        dto.setId(membre.getId());
        dto.setNom(membre.getNom());
        dto.setPrenom(membre.getPrenom());
        dto.setEmail(membre.getEmail());
        dto.setTelephone(membre.getTelephone());
        dto.setNiveau(membre.getNiveau());
        dto.setFiliere(membre.getFiliere());
        dto.setDateInscription(membre.getDateInscription());
        if (membre.getClub() != null) {
            dto.setClubId(membre.getClub().getId());
            dto.setClubNom(membre.getClub().getNom());
        }
        return dto;
    }

    private Membre convertToEntity(MembreDTO dto) {
        Membre membre = new Membre();
        membre.setId(dto.getId());
        membre.setNom(dto.getNom());
        membre.setPrenom(dto.getPrenom());
        membre.setEmail(dto.getEmail());
        membre.setTelephone(dto.getTelephone());
        membre.setNiveau(dto.getNiveau());
        membre.setFiliere(dto.getFiliere());
        membre.setDateInscription(dto.getDateInscription());
        if (dto.getClubId() != null) {
            Club club = clubRepository.findById(dto.getClubId())
                    .orElseThrow(() -> new RuntimeException("Club non trouvé avec l'ID : " + dto.getClubId()));
            membre.setClub(club);
        }
        return membre;
    }
}
