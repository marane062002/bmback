package com.bmh.services.carteSanitaire;
import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEtablissementService {
    Etablissement add(EtablissementDTO etablissementDTO);
    List<EtablissementDTO> getALl();
    EtablissementDTO getById(long id);
    void update(long id,EtablissementDTO etablissementDTO);
    void delete(long id);
    Page<EtablissementDTO> AllPagination(Pageable pageable);
}
