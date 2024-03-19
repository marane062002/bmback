package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueDecesRepository extends JpaRepository<HistoriqueDeces,Long> {
//    HistoriqueDeces findByDecesNaturelId(String decesNaturelId);
    List<HistoriqueDeces> findByDecesNaturelId(@Param("decesNaturelId") Long decesNaturelId);
}
