package com.bmh.Models.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.Enum.SexeCadavre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObstacleDefunts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String nationalite;
	private LocalDate date;
	private SexeCadavre sexe;
	private String lieu;
	private String adresseResidence;
	private String adresseDeces;
//	private statutt Statut;
	private String nomDeclarent;
	private String prenomDeclarent;
	private String cinDeclarent;
	private String observation;
//	private String pcJointeDefunts;
//	private String pcDeclarant;
//	private String pcConstateur;
	private LocalDateTime dateDeclaration;
	private LocalDateTime dateDeces;
	private LocalDateTime dateConstation;
	private String causesDeces;
	private String observationConst;
	private Integer numDeces;

	private String numRegistre;
	private String causeDeces;
//	private String descreptionDeces;
	@ManyToOne
	@JoinColumn(name="arrondissement_id")
	private Arrondissement arrondissement;

	@ManyToOne
	@JoinColumn(name = "commune_id") // Nom de la colonne faisant référence à la commune
	private Commune commune;

	@ManyToOne
	@JoinColumn(name="quartier_id")
	private Quartier quartier;
	@ManyToOne
	@JoinColumn(name="constateur_id")
	private Constateur constateur;


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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SexeCadavre getSexe() {
		return sexe;
	}

	public void setSexe(SexeCadavre sexe) {
		this.sexe = sexe;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getAdresseResidence() {
		return adresseResidence;
	}

	public void setAdresseResidence(String adresseResidence) {
		this.adresseResidence = adresseResidence;
	}

	public String getAdresseDeces() {
		return adresseDeces;
	}

	public void setAdresseDeces(String adresseDeces) {
		this.adresseDeces = adresseDeces;
	}

	public String getNomDeclarent() {
		return nomDeclarent;
	}

	public void setNomDeclarent(String nomDeclarent) {
		this.nomDeclarent = nomDeclarent;
	}

	public String getPrenomDeclarent() {
		return prenomDeclarent;
	}

	public void setPrenomDeclarent(String prenomDeclarent) {
		this.prenomDeclarent = prenomDeclarent;
	}

	public String getCinDeclarent() {
		return cinDeclarent;
	}

	public void setCinDeclarent(String cinDeclarent) {
		this.cinDeclarent = cinDeclarent;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public LocalDateTime getDateDeclaration() {
		return dateDeclaration;
	}

	public void setDateDeclaration(LocalDateTime dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public LocalDateTime getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(LocalDateTime dateDeces) {
		this.dateDeces = dateDeces;
	}

	public LocalDateTime getDateConstation() {
		return dateConstation;
	}

	public void setDateConstation(LocalDateTime dateConstation) {
		this.dateConstation = dateConstation;
	}

	public String getCausesDeces() {
		return causesDeces;
	}

	public void setCausesDeces(String causesDeces) {
		this.causesDeces = causesDeces;
	}

	public String getObservationConst() {
		return observationConst;
	}

	public void setObservationConst(String observationConst) {
		this.observationConst = observationConst;
	}

	public Integer getNumDeces() {
		return numDeces;
	}

	public void setNumDeces(Integer numDeces) {
		this.numDeces = numDeces;
	}

	public String getNumRegistre() {
		return numRegistre;
	}

	public void setNumRegistre(String numRegistre) {
		this.numRegistre = numRegistre;
	}

	public String getCauseDeces() {
		return causeDeces;
	}

	public void setCauseDeces(String causeDeces) {
		this.causeDeces = causeDeces;
	}

	public com.bmh.Models.Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(com.bmh.Models.Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	public com.bmh.Models.Commune getCommune() {
		return commune;
	}

	public void setCommune(com.bmh.Models.Commune commune) {
		this.commune = commune;
	}

	public com.bmh.Models.Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(com.bmh.Models.Quartier quartier) {
		this.quartier = quartier;
	}

	public com.bmh.Models.Constateur getConstateur() {
		return constateur;
	}

	public void setConstateur(com.bmh.Models.Constateur constateur) {
		this.constateur = constateur;
	}
}
