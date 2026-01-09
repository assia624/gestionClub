package ma.xproce.gestionclub.service;


import ma.xproce.gestionclub.dto.EvenementDTO;
import java.util.List;

public interface EvenementService {
    List<EvenementDTO> getAllEvenements();
    EvenementDTO getEvenementById(Long id);
    EvenementDTO saveEvenement(EvenementDTO evenementDTO);
    void deleteEvenement(Long id);
    List<EvenementDTO> getEvenementsAVenir();
}
