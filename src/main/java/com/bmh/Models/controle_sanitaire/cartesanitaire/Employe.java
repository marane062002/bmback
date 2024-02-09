package com.bmh.Models.controle_sanitaire.cartesanitaire;

import com.bmh.Models.Enum.Sexe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    private Sexe sexe;
    private String cnss;
    private Date dateNaissance;
    private String tel;
    private String dureCarte;
    private String email;
    private String fonction;
    private Date dateRecrutement;
    private Date dateDemendeDeCarte;
    private Date dateProchainControle;
    private String statutDemandeDeCarte;
    private String typeAnalyseDemande;
    private String resultatAnalyse;
    private Date dateResultat;
    private String Decision;
    private Number numQuittance;
    private Date dateQuittance;
    private Date dateDelivranceCarte;
    private String adresse;
    private String photo;
    private String pieceJointe;

    @OneToOne(mappedBy = "employe")
    @JsonIgnoreProperties(value = "employe")
    private Employeur employeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDureCarte() {
        return dureCarte;
    }

    public void setDureCarte(String dureCarte) {
        this.dureCarte = dureCarte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public Date getDateDemendeDeCarte() {
        return dateDemendeDeCarte;
    }

    public void setDateDemendeDeCarte(Date dateDemendeDeCarte) {
        this.dateDemendeDeCarte = dateDemendeDeCarte;
    }

    public Date getDateProchainControle() {
        return dateProchainControle;
    }

    public void setDateProchainControle(Date dateProchainControle) {
        this.dateProchainControle = dateProchainControle;
    }

    public String getStatutDemandeDeCarte() {
        return statutDemandeDeCarte;
    }

    public void setStatutDemandeDeCarte(String statutDemandeDeCarte) {
        this.statutDemandeDeCarte = statutDemandeDeCarte;
    }

    public String getTypeAnalyseDemande() {
        return typeAnalyseDemande;
    }

    public void setTypeAnalyseDemande(String typeAnalyseDemande) {
        this.typeAnalyseDemande = typeAnalyseDemande;
    }

    public String getResultatAnalyse() {
        return resultatAnalyse;
    }

    public void setResultatAnalyse(String resultatAnalyse) {
        this.resultatAnalyse = resultatAnalyse;
    }

    public Date getDateResultat() {
        return dateResultat;
    }

    public void setDateResultat(Date dateResultat) {
        this.dateResultat = dateResultat;
    }

    public String getDecision() {
        return Decision;
    }

    public void setDecision(String decision) {
        Decision = decision;
    }

    public Number getNumQuittance() {
        return numQuittance;
    }

    public void setNumQuittance(Number numQuittance) {
        this.numQuittance = numQuittance;
    }

    public Date getDateQuittance() {
        return dateQuittance;
    }

    public void setDateQuittance(Date dateQuittance) {
        this.dateQuittance = dateQuittance;
    }

    public Date getDateDelivranceCarte() {
        return dateDelivranceCarte;
    }

    public void setDateDelivranceCarte(Date dateDelivranceCarte) {
        this.dateDelivranceCarte = dateDelivranceCarte;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public Employeur getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Employeur employeur) {
        this.employeur = employeur;
    }

}
