package ma.xproce.gestionclub.service;

import ma.xproce.gestionclub.dto.MembreDTO;
import java.util.List;

public interface MembreService {
    List<MembreDTO> getAllMembres();
    MembreDTO getMembreById(Long id);
    MembreDTO saveMembre(MembreDTO membreDTO);
    void deleteMembre(Long id);
    List<MembreDTO> getMembresByClub(Long clubId);
}
