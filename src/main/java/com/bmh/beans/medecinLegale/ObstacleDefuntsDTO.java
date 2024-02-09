package com.bmh.beans.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Constateur;
import com.bmh.Models.Enum.SexeCadavre;
import com.bmh.Models.Quartier;
import com.bmh.Models.medecinLegale.*;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.ConstateurDTO;
import com.bmh.beans.QuartierDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObstacleDefuntsDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private LocalDate date;
	private SexeCadavre sexe;
	private String lieu;
	private String adresseResidence;
	private String adresseDeces;
	private String nationalite;
	private String nomDeclarent;
	private String prenomDeclarent;
	private String cinDeclarent;
	private String observation;
	private LocalDateTime dateDeclaration;
	private LocalDateTime dateDeces;
	private LocalDateTime dateConstation;
	private String causesDeces;
//	private String pcJointeDefunts;
//	private String pcDeclarant;
//	private String pcConstateur;
	private String observationConst;

	private String numRegistre;
	private String causeDeces;

//	private String descreptionDeces;
	private Constateur constateur;
	private Arrondissement arrondissement;
	private Quartier quartier;
	private Commune commune;
	private Integer numDeces;
//	private EntrementInhumation entrementInhumation;


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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
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

//	public String getPcJointeDefunts() {
//		return pcJointeDefunts;
//	}

//	public void setPcJointeDefunts(String pcJointeDefunts) {
//		this.pcJointeDefunts = pcJointeDefunts;
//	}
//
//	public String getPcDeclarant() {
//		return pcDeclarant;
//	}
//
//	public void setPcDeclarant(String pcDeclarant) {
//		this.pcDeclarant = pcDeclarant;
//	}
//
//	public String getPcConstateur() {
//		return pcConstateur;
//	}
//
//	public void setPcConstateur(String pcConstateur) {
//		this.pcConstateur = pcConstateur;
//	}

	public String getObservationConst() {
		return observationConst;
	}

	public void setObservationConst(String observationConst) {
		this.observationConst = observationConst;
	}

	public Constateur getConstateur() {
		return constateur;
	}

	public void setConstateur(Constateur constateur) {
		this.constateur = constateur;
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

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
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

//	public void setDateDeces(Date dateDeces) {
//		this.dateDeces = dateDeces;
//	}

	public String getCauseDeces() {
		return causeDeces;
	}

	public void setCauseDeces(String causeDeces) {
		this.causeDeces = causeDeces;
	}


}
