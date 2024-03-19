package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.controle_sanitaire.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long>, JpaSpecificationExecutor<Etablissement> {
//    @Query("select count(e) from Etablissement e where e.mesuresPrises = :")
    long countByMesuresPrises(MesuresPrises mesuresPrises);
    long countByMesuresPrisesAndCreatedAtBetween(MesuresPrises mesuresPrises,Date dateDebut,Date dateFin);
    long countBySaisisDestruction(SaisisDestruction saisisDestruction);
    long countBySaisisDestructionAndCreatedAtBetween(SaisisDestruction saisisDestruction, Date dateDebut, Date dateFin);

    long countByEtatHygiene(EtatHygiene etatHygiene);
    long countByNatureEtablissement(NatureEtablissement natureEtablissement);
    long countByNatureEtablissementAndCreatedAtBetween(NatureEtablissement natureEtablissement, Date dateDebut, Date dateFin);

    //    @Query("SELECT new com.example.dto.ResultatMesureDto(e.mesuresPrises, COUNT(e)) FROM Etablissement e GROUP BY e.mesuresPrises")
//    List<MesuresPrises> countByMesuresPrises();
    int countByArrondissementAndControleEffectueTrue(Arrondissement arrondissement);
    List<Etablissement> findByCreatedAtBetween(Date startDate, Date endDate);
    long countByEtatHygieneAndCreatedAtBetween(EtatHygiene etatHygiene, Date dateDebut, Date dateFin);
    @Query("SELECT COUNT(e) FROM Etablissement e WHERE e.arrondissement = :arrondissement AND e.controleEffectue = true AND e.createdAt BETWEEN :dateDebut AND :dateFin")
    long countByArrondissementAndControleEffectueTrueAndCreatedAtBetween(
            @Param("arrondissement") Arrondissement arrondissement,
            @Param("dateDebut") Date dateDebut,
            @Param("dateFin") Date dateFin
    );

    List<Etablissement> findByArrondissement(Arrondissement arrondissement);
    List<Etablissement> findAll(Specification<Etablissement> spec);

    Page<Etablissement> findByEtatHygiene(EtatHygiene etatHygiene, Pageable pageable);
    Page<Etablissement> findByNatureEtablissement(NatureEtablissement natureEtablissement, Pageable pageable);
}
