package com.bmh.Models;

import com.bmh.Models.controle_sanitaire.ListEtablissement;
import com.bmh.Models.controle_sanitaire.SousType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String lieu;
    private String adresse;
    private String procesVerbal;
    private String remarques;
    private String pieceJointe;
    @ManyToOne
    @JoinColumn(name = "objetsortie_id", unique = false)
    private ObjetSortie objetSortie;

    @ManyToOne
    @JoinColumn(name = "typetraitement_id", unique = false)
    private TypeTraitement typeTraitement;
    @ManyToMany
    @JoinTable(
            name = "equipe_sortie",
            joinColumns = @JoinColumn(name = "sortie_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private Set<Equipe> equipes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "commune_id", unique = false)
    private Commune commune;

    @ManyToOne
    @JoinColumn(name = "arrondissement_id", unique = false)
    private Arrondissement arrondissement;

    @ManyToOne
    @JoinColumn(name = "quartier_id", unique = false)
    private Quartier quartier;

    @ManyToOne
    @JoinColumn(name = "produit_id", unique = false)
    private ProduitUtilise produitUtilise;
    @ManyToOne
    @JoinColumn(name = "quantite_id", unique = false)
    private Quantite quantite;

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

    public String getProcesVerbal() {
        return procesVerbal;
    }

    public void setProcesVerbal(String procesVerbal) {
        this.procesVerbal = procesVerbal;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public ObjetSortie getObjetSortie() {
        return objetSortie;
    }

    public void setObjetSortie(ObjetSortie objetSortie) {
        this.objetSortie = objetSortie;
    }

    public TypeTraitement getTypeTraitement() {
        return typeTraitement;
    }

    public void setTypeTraitement(TypeTraitement typeTraitement) {
        this.typeTraitement = typeTraitement;
    }

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public ProduitUtilise getProduitUtilise() {
        return produitUtilise;
    }

    public void setProduitUtilise(ProduitUtilise produitUtilise) {
        this.produitUtilise = produitUtilise;
    }

    public Quantite getQuantite() {
        return quantite;
    }

    public void setQuantite(Quantite quantite) {
        this.quantite = quantite;
    }
}
