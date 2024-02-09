package com.bmh.beans.VaccinationDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class TypeAnimalDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean connu;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String cin;
    private Long numBulletin;
    private String nationalite;

    @JsonIgnoreProperties(value = "typeAnimal",allowSetters = true)
    private InfosGeneralesDto infosGenerales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getConnu() {
        return connu;
    }

    public void setConnu(Boolean connu) {
        this.connu = connu;
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

    public Long getNumBulletin() {
        return numBulletin;
    }

    public void setNumBulletin(Long numBulletin) {
        this.numBulletin = numBulletin;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}
