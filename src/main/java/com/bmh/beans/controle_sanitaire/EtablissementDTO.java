package com.bmh.beans.controle_sanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Enum.Personne;
import com.bmh.Models.Quartier;
import com.bmh.Models.controle_sanitaire.PersonnesEtab.Morale;
import com.bmh.Models.controle_sanitaire.PersonnesEtab.Physique;
import com.bmh.Models.controle_sanitaire.SousType;
import com.bmh.Models.controle_sanitaire.TypeControleSanitaire;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.QuartierDTO;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.MoraleDto;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.PhysiqueDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.lang.String;


import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String description;
    private String activite;
    private String tel;
    private String fax;
    private String ifiscal;
    private String adresse;
    private String rs;
    private String rc;
    private String nom;
    private String prenom;
    private String cin;
    private String nomProp;
    private String prenomProp;
    private Personne personne;
    private String cinPro;
    private String telProp;
    private String nomGerant;
    private String prenomGerant;
    private String cinGerant;
    private String telGerant;

    private TypeControleDTO typeControleSanitaire;

    private SousTypeDTO sousType;

    private CommuneDTO commune;

    private ArrondissementDTO arrondissement;

    private QuartierDTO quartier;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getIfiscal() {
        return ifiscal;
    }

    public void setIfiscal(String ifiscal) {
        this.ifiscal = ifiscal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomProp() {
        return nomProp;
    }

    public void setNomProp(String nomProp) {
        this.nomProp = nomProp;
    }

    public String getPrenomProp() {
        return prenomProp;
    }

    public void setPrenomProp(String prenomProp) {
        this.prenomProp = prenomProp;
    }

    public String getCinPro() {
        return cinPro;
    }

    public void setCinPro(String cinPro) {
        this.cinPro = cinPro;
    }

    public String getTelProp() {
        return telProp;
    }

    public void setTelProp(String telProp) {
        this.telProp = telProp;
    }

    public String getNomGerant() {
        return nomGerant;
    }

    public void setNomGerant(String nomGerant) {
        this.nomGerant = nomGerant;
    }

    public String getPrenomGerant() {
        return prenomGerant;
    }

    public void setPrenomGerant(String prenomGerant) {
        this.prenomGerant = prenomGerant;
    }

    public String getCinGerant() {
        return cinGerant;
    }

    public void setCinGerant(String cinGerant) {
        this.cinGerant = cinGerant;
    }

    public String getTelGerant() {
        return telGerant;
    }

    public void setTelGerant(String telGerant) {
        this.telGerant = telGerant;
    }


    public TypeControleDTO getTypeControleSanitaire() {
        return typeControleSanitaire;
    }

    public void setTypeControleSanitaire(TypeControleDTO typeControleSanitaire) {
        this.typeControleSanitaire = typeControleSanitaire;
    }

    public SousTypeDTO getSousType() {
        return sousType;
    }

    public void setSousType(SousTypeDTO sousType) {
        this.sousType = sousType;
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

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
