package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Autopsie;
import com.bmh.Models.medecinLegale.Prelevement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PrelevementRepository extends JpaRepository<Prelevement,Long> {

    @Query("SELECT e FROM Prelevement e WHERE e.obstacleDefunts.id = :obstacleDefuntsId")
    List<Prelevement> findByObstacleDefuntsId(Long obstacleDefuntsId);

    @Query(value = "SELECT " +
            "CASE " +
            "    WHEN od.sexe = 0 THEN 'Homme' " +
            "    WHEN od.sexe = 1 THEN 'Femme' " +
            "    WHEN od.sexe = 2 THEN 'NN' " +
            "    WHEN od.sexe = 3 THEN 'NRS' " +
            "    WHEN od.sexe = 4 THEN 'Enfant' " +
            "    WHEN od.sexe = 5 THEN 'Indéterminé' " +
            "END AS Sexe, " +
            "p.analyse AS AnalyseType, " +
            "p.created_at AS CreatedAt, " +
            "COUNT(*) AS NombreDePrelevements " +
            "FROM prelevement p " +
            "JOIN obstacle_defunts od ON p.obstacle_defunts_id = od.id " +
            "GROUP BY od.sexe, p.analyse, p.created_at", nativeQuery = true)
    List<Map<String, Object>> countPrelevementsBySexeAndAnalyseType();
}
