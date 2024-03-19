package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.Models.medecinLegale.HistoriqueObstacel;
import com.bmh.beans.medecinLegale.HistoriqueDecesDTO;
import com.bmh.beans.medecinLegale.HistoriqueObstacleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoriqueObstacleService {
    HistoriqueObstacel add(HistoriqueObstacleDTO historiqueObstacleDTO);

    List<HistoriqueObstacel> findByObstacleDefuntsId(Long obstacleDefuntsId);
}
