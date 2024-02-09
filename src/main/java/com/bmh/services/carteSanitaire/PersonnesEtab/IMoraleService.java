package com.bmh.services.carteSanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.PersonnesEtab.Morale;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.MoraleDto;

import java.util.List;

public interface IMoraleService {
    Morale add(MoraleDto moraleDto);
    List<MoraleDto> getALl();
    MoraleDto getById(long id);
    void update(long id,MoraleDto moraleDto);
    void delete(long id);
}
