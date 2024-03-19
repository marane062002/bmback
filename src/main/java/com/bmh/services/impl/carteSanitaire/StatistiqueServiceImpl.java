package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.controle_sanitaire.*;
import com.bmh.Repositories.ArrondissementRepository;
import com.bmh.Repositories.carteSanitaire.EtablissementRepository;
import com.bmh.Repositories.carteSanitaire.StatistiqueRepository;
import com.bmh.beans.SommeNatureDTO;
import com.bmh.beans.controle_sanitaire.SommeEtatHygDTO;
import com.bmh.beans.controle_sanitaire.SommeMesuresParArrondissementDTO;
import com.bmh.beans.controle_sanitaire.SommeSaisieDestructionDTO;
import com.bmh.beans.controle_sanitaire.StatistiqueDTO;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IStatistiqueService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatistiqueServiceImpl implements IStatistiqueService {
    private final StatistiqueRepository repository;

    private final ArrondissementRepository arrondissementRepository;
    private final EtablissementRepository etablissementRepository;
    private final Mapper mapper;

    public StatistiqueServiceImpl(StatistiqueRepository repository, ArrondissementRepository arrondissementRepository, EtablissementRepository etablissementRepository, Mapper mapper) {
        this.repository = repository;
        this.arrondissementRepository = arrondissementRepository;
        this.etablissementRepository = etablissementRepository;
        this.mapper = mapper;
    }


    @Override
    public List<StatistiqueDTO> getAllStatistiques() {
        return mapper.mapList(repository.findAll(), StatistiqueDTO.class);
    }
//    public Map<String, Long> getNombreEtablissementsControlesParArrondissement() {
//        List<Arrondissement> arrondissements = arrondissementRepository.findAll();
//        Map<String, Long> statistiques = new HashMap<>();
//
//        for (Arrondissement arrondissement : arrondissements) {
//            long nombreEtablissementsControles = etablissementRepository.countByArrondissementAndControleEffectueTrue(arrondissement);
//            statistiques.put(arrondissement.getLibelle(), nombreEtablissementsControles);
//        }
//
//        return statistiques;
//    }


    public Map<String, Long> getNombreEtablissementsControlesParArrondissement(Date dateDebut, Date dateFin) {
        List<Arrondissement> arrondissements = arrondissementRepository.findAll();
        Map<String, Long> statistiques = new HashMap<>();
        for (Arrondissement arrondissement : arrondissements) {
            long nombreEtablissementsControles;
            if (dateDebut != null && dateFin != null) {
                nombreEtablissementsControles = etablissementRepository.countByArrondissementAndControleEffectueTrueAndCreatedAtBetween(
                        arrondissement, dateDebut, dateFin);
            } else {
                nombreEtablissementsControles = etablissementRepository.countByArrondissementAndControleEffectueTrue(arrondissement);
            }
            statistiques.put(arrondissement.getLibelle(), nombreEtablissementsControles);
        }
        return statistiques;
    }


    public List<SommeMesuresParArrondissementDTO> getNombreEtablissementsByMesure(Date dateDebut, Date dateFin) {
        List<SommeMesuresParArrondissementDTO> resultatMesures = new ArrayList<>();

        Long prelevements;
        Long miseDemeurs;
        Long avertissementOrale;
        Long arretActivite;
        Long saisieDestructions;

        // If both dateDebut and dateFin are provided, filter the etablissements
        if (dateDebut != null && dateFin != null) {
            prelevements = etablissementRepository.countByMesuresPrisesAndCreatedAtBetween(MesuresPrises.Prelevements, dateDebut, dateFin);
            miseDemeurs = etablissementRepository.countByMesuresPrisesAndCreatedAtBetween(MesuresPrises.MiseDemeurs, dateDebut, dateFin);
            avertissementOrale = etablissementRepository.countByMesuresPrisesAndCreatedAtBetween(MesuresPrises.AvertissementOrale, dateDebut, dateFin);
            arretActivite = etablissementRepository.countByMesuresPrisesAndCreatedAtBetween(MesuresPrises.ArretActivite, dateDebut, dateFin);
            saisieDestructions = etablissementRepository.countByMesuresPrisesAndCreatedAtBetween(MesuresPrises.SaisieDestructions, dateDebut, dateFin);
        } else {
            prelevements = etablissementRepository.countByMesuresPrises(MesuresPrises.Prelevements);
            miseDemeurs = etablissementRepository.countByMesuresPrises(MesuresPrises.MiseDemeurs);
            avertissementOrale = etablissementRepository.countByMesuresPrises(MesuresPrises.AvertissementOrale);
            arretActivite = etablissementRepository.countByMesuresPrises(MesuresPrises.ArretActivite);
            saisieDestructions = etablissementRepository.countByMesuresPrises(MesuresPrises.SaisieDestructions);
        }

        SommeMesuresParArrondissementDTO dto = new SommeMesuresParArrondissementDTO();
        dto.setPrelevements(prelevements);
        dto.setMiseDemeurs(miseDemeurs);
        dto.setAvertissementOrale(avertissementOrale);
        dto.setArretActivite(arretActivite);
        dto.setSaisieDestructions(saisieDestructions);
        resultatMesures.add(dto);

        return resultatMesures;
    }


    public List<SommeSaisieDestructionDTO> getSommeDestruction(Date dateDebut, Date dateFin) {
        List<SommeSaisieDestructionDTO> resultat = new ArrayList<>();

        Long Kg;
        Long Litre;
        Long Unite;

        // If both dateDebut and dateFin are provided, filter the etablissements
        if (dateDebut != null && dateFin != null) {
            Kg = etablissementRepository.countBySaisisDestructionAndCreatedAtBetween(SaisisDestruction.Kg, dateDebut, dateFin);
            Litre = etablissementRepository.countBySaisisDestructionAndCreatedAtBetween(SaisisDestruction.Litre, dateDebut, dateFin);
            Unite = etablissementRepository.countBySaisisDestructionAndCreatedAtBetween(SaisisDestruction.Unite, dateDebut, dateFin);
        } else {
            Kg = etablissementRepository.countBySaisisDestruction(SaisisDestruction.Kg);
            Litre = etablissementRepository.countBySaisisDestruction(SaisisDestruction.Litre);
            Unite = etablissementRepository.countBySaisisDestruction(SaisisDestruction.Unite);
        }

        SommeSaisieDestructionDTO dto = new SommeSaisieDestructionDTO();
        dto.setKg(Kg);
        dto.setLitre(Litre);
        dto.setUnite(Unite);

        resultat.add(dto);

        return resultat;
    }

    public List<SommeEtatHygDTO> getSommeEtatHg(Date dateDebut, Date dateFin) {
        List<SommeEtatHygDTO> resultat = new ArrayList<>();

        Long EHS;
        Long EHM;
        Long EHNS;

        if (dateDebut != null && dateFin != null) {
            EHS = etablissementRepository.countByEtatHygieneAndCreatedAtBetween(EtatHygiene.EHS, dateDebut, dateFin);
            EHM = etablissementRepository.countByEtatHygieneAndCreatedAtBetween(EtatHygiene.EHM, dateDebut, dateFin);
            EHNS = etablissementRepository.countByEtatHygieneAndCreatedAtBetween(EtatHygiene.EHNS, dateDebut, dateFin);
        } else {
            EHS = etablissementRepository.countByEtatHygiene(EtatHygiene.EHS);
            EHM = etablissementRepository.countByEtatHygiene(EtatHygiene.EHM);
            EHNS = etablissementRepository.countByEtatHygiene(EtatHygiene.EHNS);
        }

        SommeEtatHygDTO dto = new SommeEtatHygDTO();
        dto.setEHS(EHS);
        dto.setEHM(EHM);
        dto.setEHNS(EHNS);
        resultat.add(dto);

        return resultat;
    }

    public List<SommeNatureDTO> getSommeNature(Date dateDebut, Date dateFin) {
        List<SommeNatureDTO> resultat = new ArrayList<>();

        Long Alimentaires;
        Long Publics;
        Long Touristiques;

        // If both dateDebut and dateFin are provided, filter the etablissements
        if (dateDebut != null && dateFin != null) {
            Alimentaires = etablissementRepository.countByNatureEtablissementAndCreatedAtBetween(NatureEtablissement.Alimentaires, dateDebut, dateFin);
            Publics = etablissementRepository.countByNatureEtablissementAndCreatedAtBetween(NatureEtablissement.Publics, dateDebut, dateFin);
            Touristiques = etablissementRepository.countByNatureEtablissementAndCreatedAtBetween(NatureEtablissement.Touristiques, dateDebut, dateFin);
        } else {
            Alimentaires = etablissementRepository.countByNatureEtablissement(NatureEtablissement.Alimentaires);
            Publics = etablissementRepository.countByNatureEtablissement(NatureEtablissement.Publics);
            Touristiques = etablissementRepository.countByNatureEtablissement(NatureEtablissement.Touristiques);
        }

        SommeNatureDTO dto = new SommeNatureDTO();
        dto.setAlimentaires(Alimentaires);
        dto.setPublics(Publics);
        dto.setTouristiques(Touristiques);

        resultat.add(dto);

        return resultat;
    }


    //    public List<MesuresPrises> getNombreEtablissementsByMesure() {
//        List<MesuresPrises> resultats = new ArrayList<>();
//        for (MesuresPrises mesure : MesuresPrises.values()) {
//            Long nombreEtablissements = etablissementRepository.countByMesuresPrises(mesure);
//            MesuresPrises dto = new MesuresPrises(mesure, nombreEtablissements);
//            resultats.add(dto);
//        }
//        return resultats;
//    }
    public Map<String, Map<EtatHygiene, Long>> getStatistiquesParArrondissement(Date dateDebut, Date dateFin) {
        List<Etablissement> etablissements;

        // If both dateDebut and dateFin are provided, filter the etablissements
        if (dateDebut != null && dateFin != null) {
            etablissements = etablissementRepository.findByCreatedAtBetween(dateDebut, dateFin);
        } else {
            etablissements = etablissementRepository.findAll();
        }

        Map<String, Map<EtatHygiene, Long>> statistiques = new HashMap<>();

        // Parcourir tous les établissements pour calculer les statistiques par arrondissement
        for (Etablissement etablissement : etablissements) {
            String nomArrondissement = etablissement.getArrondissement().getLibelle();
            EtatHygiene etatHygiene = etablissement.getEtatHygiene();

            // Mettre à jour les statistiques pour l'arrondissement en cours
            statistiques.computeIfAbsent(nomArrondissement, k -> new HashMap<>());
            Map<EtatHygiene, Long> statistiquesArrondissement = statistiques.get(nomArrondissement);
            statistiquesArrondissement.put(etatHygiene, statistiquesArrondissement.getOrDefault(etatHygiene, 0L) + 1);
        }

        return statistiques;
    }

    public Map<String, Map<NatureEtablissement, Long>> getStatistiquesParNature(Date dateDebut, Date dateFin) {
        List<Etablissement> etablissements;
        if (dateDebut != null && dateFin != null) {
            etablissements = etablissementRepository.findByCreatedAtBetween(dateDebut, dateFin);
        } else {
            etablissements = etablissementRepository.findAll();
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Map<String, Map<NatureEtablissement, Long>> statistiques = new HashMap<>();
        for (Etablissement etablissement : etablissements) {
            String nomArrondissement = etablissement.getArrondissement().getLibelle();
            NatureEtablissement natureEtablissement = etablissement.getNatureEtablissement();
            statistiques.computeIfAbsent(nomArrondissement, k -> new HashMap<>());
            Map<NatureEtablissement, Long> statistiquesArrondissement = statistiques.get(nomArrondissement);
            statistiquesArrondissement.put(natureEtablissement, statistiquesArrondissement.getOrDefault(natureEtablissement, 0L) + 1);
        }
        statistiques.entrySet().removeIf(entry -> entry.getKey() == null);

        return statistiques;
    }

    public Map<String, Map<MesuresPrises, Long>> getStatistiquesParMesures(Date dateDebut, Date dateFin) {
        List<Etablissement> etablissements;

        // If both dateDebut and dateFin are provided, filter the etablissements
        if (dateDebut != null && dateFin != null) {
            etablissements = etablissementRepository.findByCreatedAtBetween(dateDebut, dateFin);
        } else {
            etablissements = etablissementRepository.findAll();
        }
        Map<String, Map<MesuresPrises, Long>> statistiques = new HashMap<>();
        for (Etablissement etablissement : etablissements) {
            String nomArrondissement = etablissement.getArrondissement().getLibelle();
            MesuresPrises mesuresPrises = etablissement.getMesuresPrises();

            statistiques.computeIfAbsent(nomArrondissement, k -> new HashMap<>());
            Map<MesuresPrises, Long> statistiquesArrondissement = statistiques.get(nomArrondissement);
            statistiquesArrondissement.put(mesuresPrises, statistiquesArrondissement.getOrDefault(mesuresPrises, 0L) + 1);
        }

        return statistiques;
    }

    public Map<String, Map<SaisisDestruction, Long>> getTotalParUnite(Date dateDebut, Date dateFin) {
        List<Etablissement> etablissements;

        // If both dateDebut and dateFin are provided, filter the etablissements
        if (dateDebut != null && dateFin != null) {
            etablissements = etablissementRepository.findByCreatedAtBetween(dateDebut, dateFin);
        } else {
            etablissements = etablissementRepository.findAll();
        }

        Map<String, Map<SaisisDestruction, Long>> statistiques = new HashMap<>();

        for (Etablissement etablissement : etablissements) {
            if (etablissement.getSaisisDestruction() != null) {
                String nomArrondissement = etablissement.getArrondissement().getLibelle();
                SaisisDestruction saisisDestruction = etablissement.getSaisisDestruction();

                statistiques.computeIfAbsent(nomArrondissement, k -> new HashMap<>());
                Map<SaisisDestruction, Long> statistiquesArrondissement = statistiques.get(nomArrondissement);
                statistiquesArrondissement.put(saisisDestruction, statistiquesArrondissement.getOrDefault(saisisDestruction, 0L) + 1);
            }
        }

        return statistiques;
    }

/*    public Map<SaisisDestruction, Long> getTotalParUnite() {
        List<Etablissement> etablissements = etablissementRepository.findAll();
        Map<SaisisDestruction, Long> statistiquesTotales = new HashMap<>();

        // Parcourir tous les établissements pour calculer les statistiques totales par unité
        for (Etablissement etablissement : etablissements) {
            SaisisDestruction saisieDestruction = etablissement.getSaisisDestruction();

            // Mettre à jour les statistiques totales pour l'unité en cours
            statistiquesTotales.put(saisieDestruction, statistiquesTotales.getOrDefault(saisieDestruction, 0L) + 1);
        }

        return statistiquesTotales;
    }*/

//    public List<SommeMesuresParArrondissementDTO> calculerSommeMesuresPrisesParArrondissement() {
//        List<SommeMesuresParArrondissementDTO> resultat = new ArrayList<>();
//        List<Arrondissement> arrondissements = arrondissementRepository.findAll();// récupérez tous les arrondissements depuis votre repository
//
//        for (Arrondissement arrondissement : arrondissements) {
//            List<Etablissement> etablissements = etablissementRepository.findByArrondissement(arrondissement);
//            int totalPrelevements = 0;
//            int totalMiseDemeurs = 0;
//            int totalAvertissementOrale = 0;
//            int totalArretActivite = 0;
//            int totalSaisieDestructions = 0;
//
//            for (Etablissement etablissement : etablissements) {
//                switch (etablissement.getMesuresPrises()) {
//                    case Prelevements:
//                        totalPrelevements++;
//                        break;
//                    case MiseDemeurs:
//                        totalMiseDemeurs++;
//                        break;
//                    case AvertissementOrale:
//                        totalAvertissementOrale++;
//                        break;
//                    case ArretActivite:
//                        totalArretActivite++;
//                        break;
//                    case SaisieDestructions:
//                        totalSaisieDestructions++;
//                        break;
//                }
//            }
//
//            SommeMesuresParArrondissementDTO sommeDTO = new SommeMesuresParArrondissementDTO(
//                    arrondissement, totalPrelevements, totalMiseDemeurs, totalAvertissementOrale,
//                    totalArretActivite, totalSaisieDestructions
//            );
//            resultat.add(sommeDTO);
//        }
//
//        return resultat;
//    }



}
