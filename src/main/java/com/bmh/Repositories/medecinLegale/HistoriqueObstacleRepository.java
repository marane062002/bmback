package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.Models.medecinLegale.HistoriqueObstacel;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueObstacleRepository extends JpaRepository<HistoriqueObstacel,Long> {
    List<HistoriqueObstacel> findByObstacleDefuntsId(@Param("obstacleDefuntsId") Long obstacleDefuntsId);
}
