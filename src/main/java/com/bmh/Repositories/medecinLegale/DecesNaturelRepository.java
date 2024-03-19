package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.medecinLegale.DecesNaturel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DecesNaturelRepository extends JpaRepository<DecesNaturel,Long>, JpaSpecificationExecutor<DecesNaturel> {

    @Query(value = "SELECT d.constater AS Constater, " +
            "CASE " +
            "    WHEN d.sexe = 0 THEN 'Homme' " +
            "    WHEN d.sexe = 1 THEN 'Femme' " +
            "    WHEN d.sexe = 2 THEN 'NN' " +
            "    WHEN d.sexe = 3 THEN 'NRS' " +
            "    WHEN d.sexe = 4 THEN 'Enfant' " +
            "    WHEN d.sexe = 5 THEN 'Indéterminé' " +
            "END AS Sexe, " +
            "COUNT(*) AS NombreDeDeces, " +
            "d.created_at AS CreatedAt " + // Include the created_at column
            "FROM [dbo].[deces_naturel] d " +
            "GROUP BY d.constater, d.sexe, d.created_at", // Group by created_at as well
            nativeQuery = true)
    List<Map<String, Object>> countDeathsByConstaterAndSexe();

    List<DecesNaturel> findAll(Specification<DecesNaturel> spec);
    @Query(value = "SELECT a.libelle AS Arrondissement, " +
            "CASE " +
            "    WHEN d.sexe = 0 THEN 'Homme' " +
            "    WHEN d.sexe = 1 THEN 'Femme' " +
            "    WHEN d.sexe = 2 THEN 'NN' " +
            "    WHEN d.sexe = 3 THEN 'NRS' " +
            "    WHEN d.sexe = 4 THEN 'Enfant' " +
            "    WHEN d.sexe = 5 THEN 'Indéterminé' " +
            "END AS Sexe, " +
            "COUNT(*) AS NombreDeDeces, " +
            "d.created_at AS CreatedAt " + // Include the created_at column
            "FROM [dbo].[deces_naturel] d " +
            "LEFT OUTER JOIN [dbo].[arrondissement] a ON a.id = d.arrondissement_id " +
            "GROUP BY a.libelle, d.sexe, d.created_at", // Group by created_at as well
            nativeQuery = true)
    List<Map<String, Object>> countDeathsByArrondissementAndSexe();


}
