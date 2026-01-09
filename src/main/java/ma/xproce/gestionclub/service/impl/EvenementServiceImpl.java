package ma.xproce.gestionclub.service.impl;


import ma.xproce.gestionclub.dto.EvenementDTO;
import ma.xproce.gestionclub.entity.Club;
import ma.xproce.gestionclub.entity.Evenement;
import ma.xproce.gestionclub.repository.ClubRepository;
import ma.xproce.gestionclub.repository.EvenementRepository;
import ma.xproce.gestionclub.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<EvenementDTO> getAllEvenements() {
        return evenementRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EvenementDTO getEvenementById(Long id) {
        Evenement evenement = evenementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec l'ID : " + id));
        return convertToDTO(evenement);
    }

    @Override
    public EvenementDTO saveEvenement(EvenementDTO evenementDTO) {
        Evenement evenement = convertToEntity(evenementDTO);
        Evenement savedEvenement = evenementRepository.save(evenement);
        return convertToDTO(savedEvenement);
    }

    @Override
    public void deleteEvenement(Long id) {
        if (!evenementRepository.existsById(id)) {
            throw new RuntimeException("Événement non trouvé avec l'ID : " + id);
        }
        evenementRepository.deleteById(id);
    }

    @Override
    public List<EvenementDTO> getEvenementsAVenir() {
        return evenementRepository.findByDateDebutAfter(LocalDateTime.now()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Méthodes privées de conversion
    private EvenementDTO convertToDTO(Evenement evenement) {
        EvenementDTO dto = new EvenementDTO();
        dto.setId(evenement.getId());
        dto.setTitre(evenement.getTitre());
        dto.setDescription(evenement.getDescription());
        dto.setDateDebut(evenement.getDateDebut());
        dto.setDateFin(evenement.getDateFin());
        dto.setLieu(evenement.getLieu());
        dto.setCapacite(evenement.getCapacite());
        if (evenement.getClub() != null) {
            dto.setClubId(evenement.getClub().getId());
            dto.setClubNom(evenement.getClub().getNom());
        }
        return dto;
    }

    private Evenement convertToEntity(EvenementDTO dto) {
        Evenement evenement = new Evenement();
        evenement.setId(dto.getId());
        evenement.setTitre(dto.getTitre());
        evenement.setDescription(dto.getDescription());
        evenement.setDateDebut(dto.getDateDebut());
        evenement.setDateFin(dto.getDateFin());
        evenement.setLieu(dto.getLieu());
        evenement.setCapacite(dto.getCapacite());
        if (dto.getClubId() != null) {
            Club club = clubRepository.findById(dto.getClubId())
                    .orElseThrow(() -> new RuntimeException("Club non trouvé avec l'ID : " + dto.getClubId()));
            evenement.setClub(club);
        }
        return evenement;
    }
}