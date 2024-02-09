package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Cadavre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadavreRepository extends JpaRepository<Cadavre,Long> {
    List<Cadavre> findByObstacleDefunts_Id(Long id);
}
