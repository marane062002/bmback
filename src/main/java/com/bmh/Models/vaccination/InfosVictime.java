package com.bmh.Models.vaccination;

import com.bmh.Models.Enum.Personne;
import com.bmh.Models.Enum.Sexe;
import com.bmh.Models.Enum.StatutVictime;
import com.bmh.Models.Status;
import com.bmh.Models.VctStatut;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InfosVictime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatutVictime statutVictime;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String cin;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String adresse;
    private String nomTuteur;
    private String prenomTuteur;
    private String cinTuteur;
    private Date dateVaccination;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    private Date datePremierAppel;
    private String statutPremierRappel;
    private Date dateReellePremierRappel;
    private Date datePrvDernierRappel;
    private String statutDernierRappel;
    private Date dateReelleDernierRappel;

    @OneToOne(mappedBy = "infosVictime")
    @JsonIgnoreProperties(value = "infosVictime")
    private InfosGenerales infosGenerales;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public InfosGenerales getInfosGenerales() {
        return infosGenerales;
    }

    public void setInfosGenerales(InfosGenerales infosGenerales) {
        this.infosGenerales = infosGenerales;
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
}
