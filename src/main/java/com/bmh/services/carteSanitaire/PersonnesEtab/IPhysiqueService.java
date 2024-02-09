package com.bmh.services.carteSanitaire.PersonnesEtab;


import com.bmh.Models.controle_sanitaire.PersonnesEtab.Physique;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.PhysiqueDto;

import java.util.List;

public interface IPhysiqueService {
    Physique add(PhysiqueDto physiqueDto);
    List<PhysiqueDto> getALl();
    PhysiqueDto getById(long id);
    void update(long id,PhysiqueDto physiqueDto);
    void delete(long id);
}
