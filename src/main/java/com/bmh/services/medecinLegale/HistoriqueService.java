package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.beans.medecinLegale.HistoriqueDecesDTO;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoriqueService {

    HistoriqueDeces add(HistoriqueDecesDTO historiqueDecesDTO);

    List<HistoriqueDeces> findByDecesNaturelId(Long decesNaturelId);
}
