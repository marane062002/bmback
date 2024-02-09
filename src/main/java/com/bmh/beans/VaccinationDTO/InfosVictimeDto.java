package com.bmh.beans.VaccinationDTO;

import com.bmh.Models.Enum.Sexe;
import com.bmh.Models.Enum.StatutVictime;
import com.bmh.Models.VctStatut;
import com.bmh.beans.StatusDTO;
import com.bmh.beans.controle_sanitaire.ConventionDTO;
import com.bmh.beans.controle_sanitaire.SousTypeDTO;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.beans.medecinLegale.EntrementInhumationDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class InfosVictimeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private StatutVictime statutVictime;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String cin;
    private Sexe sexe;
    private String adresse;
    private String nomTuteur;
    private String prenomTuteur;
    private String cinTuteur;
    private Date dateVaccination;

//    @ManyToOne
//    @JoinColumn(name = "statut_id")
//    private VctStatut statut;


    private Date datePremierAppel;
    private String statutPremierRappel;
    private Date dateReellePremierRappel;
    private Date datePrvDernierRappel;
    private String statutDernierRappel;
    private Date dateReelleDernierRappel;

    @JsonIgnoreProperties("infosVictimeDto")
    private StatusDTO status;

    @JsonIgnoreProperties(value = "infosVictime",allowSetters = true)
    private InfosGeneralesDto infosGenerales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutVictime getStatutVictime() {
        return statutVictime;
    }

    public void setStatutVictime(StatutVictime statutVictime) {
        this.statutVictime = statutVictime;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public String getPrenomTuteur() {
        return prenomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        this.prenomTuteur = prenomTuteur;
    }

    public String getCinTuteur() {
        return cinTuteur;
    }

    public void setCinTuteur(String cinTuteur) {
        this.cinTuteur = cinTuteur;
    }

    public Date getDateVaccination() {
        return dateVaccination;
    }

    public void setDateVaccination(Date dateVaccination) {
        this.dateVaccination = dateVaccination;
    }

    public Date getDatePremierAppel() {
        return datePremierAppel;
    }

    public void setDatePremierAppel(Date datePremierAppel) {
        this.datePremierAppel = datePremierAppel;
    }

    public String getStatutPremierRappel() {
        return statutPremierRappel;
    }

    public void setStatutPremierRappel(String statutPremierRappel) {
        this.statutPremierRappel = statutPremierRappel;
    }

    public Date getDateReellePremierRappel() {
        return dateReellePremierRappel;
    }

    public void setDateReellePremierRappel(Date dateReellePremierRappel) {
        this.dateReellePremierRappel = dateReellePremierRappel;
    }

    public Date getDatePrvDernierRappel() {
        return datePrvDernierRappel;
    }

    public void setDatePrvDernierRappel(Date datePrvDernierRappel) {
        this.datePrvDernierRappel = datePrvDernierRappel;
    }

    public String getStatutDernierRappel() {
        return statutDernierRappel;
    }

    public void setStatutDernierRappel(String statutDernierRappel) {
        this.statutDernierRappel = statutDernierRappel;
    }

    public Date getDateReelleDernierRappel() {
        return dateReelleDernierRappel;
    }

    public void setDateReelleDernierRappel(Date dateReelleDernierRappel) {
        this.dateReelleDernierRappel = dateReelleDernierRappel;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public InfosGeneralesDto getInfosGenerales() {
        return infosGenerales;
    }

    public void setInfosGenerales(InfosGeneralesDto infosGenerales) {
        this.infosGenerales = infosGenerales;
    }
}
