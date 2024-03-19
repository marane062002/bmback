package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExamenRepository extends JpaRepository<Examen,Long> {

    @Query(value = "SELECT " +
            "CASE " +
            "    WHEN od.sexe = 0 THEN 'Homme' " +
            "    WHEN od.sexe = 1 THEN 'Femme' " +
            "    WHEN od.sexe = 2 THEN 'NN' " +
            "    WHEN od.sexe = 3 THEN 'NRS' " +
            "    WHEN od.sexe = 4 THEN 'Enfant' " +
            "    WHEN od.sexe = 5 THEN 'Indéterminé' " +
            "END AS Sexe, " +
            "e.created_at AS CreatedAt, " +
            "COUNT(*) AS NombreDeExams " +
            "FROM examen e " +
            "JOIN obstacle_defunts od ON e.obstacle_defunts_id = od.id " +
            "GROUP BY od.sexe, e.created_at",
            nativeQuery = true)
    List<Map<String, Object>> countBySexe();

    @Query("SELECT e FROM Examen e WHERE e.obstacleDefunts.id = :obstacleDefuntsId")
    List<Examen> findByObstacleDefuntsId(Long obstacleDefuntsId);
}
