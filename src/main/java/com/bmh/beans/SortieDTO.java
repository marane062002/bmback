package com.bmh.beans;

import com.bmh.Models.*;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.ConventionDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class SortieDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String lieu;
    private String adresse;
//    private String procesVerbal;
    private String remarques;
//    private String pieceJointe;
    private Set<EquipeDTO> equipes;
    @JsonIgnoreProperties("sortieDto")
    private ObjetSortieDTO objetSortie;
    @JsonIgnoreProperties("sortieDto")
    private TypeTraitementDTO typeTraitement;
    @JsonIgnoreProperties(value = {"sortieDto", "decesNaturels"})
    private CommuneDTO commune;
    @JsonIgnoreProperties(value = {"sortieDto","decesNaturels"})
    private ArrondissementDTO arrondissement;
    @JsonIgnoreProperties(value = {"sortieDto","decesNaturels"})
    private QuartierDTO quartier;
    @JsonIgnoreProperties("sortieDto")
    private ProduitUtiliseDTO produitUtilise;
    @JsonIgnoreProperties(value = {"sortieDto","decesNaturels"})
    private QuantiteDTO quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }


    public Set<EquipeDTO> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<EquipeDTO> equipes) {
        this.equipes = equipes;
    }

    public ObjetSortieDTO getObjetSortie() {
        return objetSortie;
    }

    public void setObjetSortie(ObjetSortieDTO objetSortie) {
        this.objetSortie = objetSortie;
    }

    public TypeTraitementDTO getTypeTraitement() {
        return typeTraitement;
    }

    public void setTypeTraitement(TypeTraitementDTO typeTraitement) {
        this.typeTraitement = typeTraitement;
    }

    public CommuneDTO getCommune() {
        return commune;
    }

    public void setCommune(CommuneDTO commune) {
        this.commune = commune;
    }

    public ArrondissementDTO getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(ArrondissementDTO arrondissement) {
        this.arrondissement = arrondissement;
    }

    public QuartierDTO getQuartier() {
        return quartier;
    }

    public void setQuartier(QuartierDTO quartier) {
        this.quartier = quartier;
    }

    public ProduitUtiliseDTO getProduitUtilise() {
        return produitUtilise;
    }

    public void setProduitUtilise(ProduitUtiliseDTO produitUtilise) {
        this.produitUtilise = produitUtilise;
    }

    public QuantiteDTO getQuantite() {
        return quantite;
    }

    public void setQuantite(QuantiteDTO quantite) {
        this.quantite = quantite;
    }
}
