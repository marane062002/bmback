package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Repository
public interface ObstacleDefuntsRepository extends JpaRepository<ObstacleDefunts,Long>, JpaSpecificationExecutor<ObstacleDefunts> {

    @Query(nativeQuery = true, value =
            "SELECT " +
                    "    Nationalite, " +
                    "    Categorie AS Sexe, " +
                    "    NombreDeDefunts AS TotalDefunts, " +
                    "    NombreDeDeces AS TotalDeces, " +
                    "    (NombreDeDefunts + NombreDeDeces) AS Total, " +
                    "    CreatedAt AS LatestCreatedAt " +
                    "FROM ( " +
                    "    SELECT " +
                    "        Nationalite, " +
                    "        Categorie, " +
                    "        NombreDeDefunts, " +
                    "        0 AS NombreDeDeces, " +
                    "        od_created_at AS CreatedAt " +
                    "    FROM ( " +
                    "        SELECT " +
                    "            o.nationalite AS Nationalite, " +
                    "            CASE " +
                    "                WHEN o.sexe = 0 THEN 'Homme' " +
                    "                WHEN o.sexe = 1 THEN 'Femme' " +
                    "                WHEN o.sexe = 2 THEN 'NN' " +
                    "                WHEN o.sexe = 3 THEN 'NRS' " +
                    "                WHEN o.sexe = 4 THEN 'Enfant' " +
                    "                WHEN o.sexe = 5 THEN 'Indéterminé' " +
                    "            END AS Categorie, " +
                    "            COUNT(*) AS NombreDeDefunts, " +
                    "            o.created_at AS od_created_at " +
                    "        FROM obstacle_defunts o " +
                    "        GROUP BY o.nationalite, o.sexe, o.created_at " +
                    "    ) AS Defunts " +
                    "    UNION ALL " +
                    "    SELECT " +
                    "        Nationalite, " +
                    "        Categorie, " +
                    "        0 AS NombreDeDefunts, " +
                    "        NombreDeDeces, " +
                    "        d_created_at AS CreatedAt " +
                    "    FROM ( " +
                    "        SELECT " +
                    "            d.nationalite AS Nationalite, " +
                    "            CASE " +
                    "                WHEN d.sexe = 0 THEN 'Homme' " +
                    "                WHEN d.sexe = 1 THEN 'Femme' " +
                    "                WHEN d.sexe = 2 THEN 'NN' " +
                    "                WHEN d.sexe = 3 THEN 'NRS' " +
                    "                WHEN d.sexe = 4 THEN 'Enfant' " +
                    "                WHEN d.sexe = 5 THEN 'Indéterminé' " +
                    "            END AS Categorie, " +
                    "            COUNT(*) AS NombreDeDeces, " +
                    "            d.created_at AS d_created_at " +
                    "        FROM deces_naturel d " +
                    "        GROUP BY d.nationalite, d.sexe, d.created_at " +
                    "    ) AS Deces " +
                    ") AS CombinedResults"
    )
    List<Map<String, Object>> countDefuntsByNationaliteAndSexe();
    List<ObstacleDefunts> findAll(Specification<ObstacleDefunts> spec);
}
