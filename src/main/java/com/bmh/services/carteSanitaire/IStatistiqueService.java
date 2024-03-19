package com.bmh.services.carteSanitaire;

import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.beans.controle_sanitaire.StatistiqueDTO;

import java.util.List;

public interface IStatistiqueService {
    List<StatistiqueDTO> getAllStatistiques();
}
