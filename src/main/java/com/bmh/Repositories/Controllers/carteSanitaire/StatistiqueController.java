package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.MesuresPrises;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import com.bmh.Models.controle_sanitaire.SaisisDestruction;
import com.bmh.beans.SommeNatureDTO;
import com.bmh.beans.controle_sanitaire.SommeEtatHygDTO;
import com.bmh.beans.controle_sanitaire.SommeMesuresParArrondissementDTO;
import com.bmh.beans.controle_sanitaire.SommeSaisieDestructionDTO;
import com.bmh.services.impl.carteSanitaire.StatistiqueServiceImpl;
import com.bmh.utils.NullKeySerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistique")
public class StatistiqueController {
    private final StatistiqueServiceImpl service;

    public StatistiqueController(StatistiqueServiceImpl service) {
        this.service = service;
    }
    @GetMapping()
    public Map<String, Long> getNombreEtablissementsControlesParArrondissement(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return service.getNombreEtablissementsControlesParArrondissement(dateDebut, dateFin);
    }

        @GetMapping("/arrondissements")
        public ResponseEntity<Map<String, Map<EtatHygiene, Long>>> getStatistiquesParArrondissement(
                @RequestParam(value = "dateDebut", required = false)
                @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                @RequestParam(value = "dateFin", required = false)
                @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin
        ) {
//            Map<String, Map<EtatHygiene, Long>> statistiques = service.getStatistiquesParArrondissement();
            Map<String, Map<EtatHygiene, Long>> statistiques = service.getStatistiquesParArrondissement(dateDebut, dateFin);
            Map<String, Map<EtatHygiene, Long>> filteredStatistiques = new HashMap<>();
            for (Map.Entry<String, Map<EtatHygiene, Long>> entry : statistiques.entrySet()) {
                if (entry.getKey() != null) {
                    filteredStatistiques.put(entry.getKey(), entry.getValue());
                }
            }
            return ResponseEntity.ok().body(filteredStatistiques);
        }

    @GetMapping("/nature")
    public ResponseEntity<Map<String, Map<NatureEtablissement, Long>>> getStatistiquesParNature(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        Map<String, Map<NatureEtablissement, Long>> statistiques = service.getStatistiquesParNature(dateDebut, dateFin);
        return ResponseEntity.ok().body(statistiques);
    }

    @GetMapping("/mesures")
    public ResponseEntity<Map<String, Map<MesuresPrises, Long>>> getStatistiquesParMesures(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        Map<String, Map<MesuresPrises, Long>> statistiques = service.getStatistiquesParMesures(dateDebut, dateFin);
        // Print the content of the Map for debugging
        System.out.println("Contenu de la Map statistiques : " + statistiques);
        return ResponseEntity.ok().body(statistiques);
    }

    @GetMapping("/unite")
    public ResponseEntity<Map<String, Map<SaisisDestruction, Long>>> getStatistiquesParUnite(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        Map<String, Map<SaisisDestruction, Long>> statistiques = service.getTotalParUnite(dateDebut, dateFin);
        // Print the content of the Map for debugging
        System.out.println("Contenu de la Map statistiques : " + statistiques);
        return ResponseEntity.ok().body(statistiques);
    }

    @GetMapping("/totalMesure")
    public ResponseEntity<List<SommeMesuresParArrondissementDTO>> getNombreEtablissementsParMesure(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        List<SommeMesuresParArrondissementDTO> nombreEtablissements = service.getNombreEtablissementsByMesure(dateDebut, dateFin);
        return ResponseEntity.ok().body(nombreEtablissements);
    }

    @GetMapping("/totalUnite")
    public ResponseEntity<List<SommeSaisieDestructionDTO>> getNombreEtablissementsParDestruction(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        List<SommeSaisieDestructionDTO> nombreEtablissements = service.getSommeDestruction(dateDebut, dateFin);
        return ResponseEntity.ok().body(nombreEtablissements);
    }

    @GetMapping("/totalEtatHg")
    public ResponseEntity<List<SommeEtatHygDTO>> getNombreEtablissementsParEtatHg(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        List<SommeEtatHygDTO> nombreEtablissements = service.getSommeEtatHg(dateDebut,dateFin);
        return ResponseEntity.ok().body(nombreEtablissements);
    }

    @GetMapping("/totalNature")
    public ResponseEntity<List<SommeNatureDTO>> getNombreEtablissementsParNature(
            @RequestParam(value = "dateDebut", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        List<SommeNatureDTO> nombreEtablissements = service.getSommeNature(dateDebut, dateFin);
        return ResponseEntity.ok().body(nombreEtablissements);
    }

//    @GetMapping("/unite")
//    public ResponseEntity<Map<SaisisDestruction, Long>> getTotalParUnite() {
//        Map<SaisisDestruction, Long> statistiquesTotales = service.getTotalParUnite();
//
//        // Supprimer les entrées avec des clés null, si elles existent
//        statistiquesTotales.entrySet().removeIf(entry -> entry.getKey() == null);
//
//        return ResponseEntity.ok().body(statistiquesTotales);
//    }

//    @GetMapping("/mesure-arroondissement")
//    public ResponseEntity<List<SommeMesuresParArrondissementDTO>> calculerSommeMesuresPrisesParArrondissement() {
//        List<SommeMesuresParArrondissementDTO> resultat = service.calculerSommeMesuresPrisesParArrondissement();
//        return ResponseEntity.ok(resultat);
//    }

}
