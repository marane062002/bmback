package com.bmh.Models.vaccination;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeAnimal {
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
    @OneToOne(mappedBy = "typeAnimal")
    @JsonIgnoreProperties(value = "typeAnimal")
    private InfosGenerales infosGenerales;
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
