package com.bmh.Models.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.Enum.SexeCadavre;
import com.bmh.Models.Enum.StatusCadavre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    private String Constater;
	private String nomDeclarent;
	private String prenomDeclarent;
	private String cinDeclarent;
	private String observation;

	@Column(name = "created_at")
	private Date createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	private LocalDate dateDeclaration;
	private LocalDate dateDeces;
	private LocalDate dateConstation;
	private String causesDeces;
	private String observationConst;
	private Integer numDeces;
	private StatusCadavre statusCadavre;
	private String numRegistre;
	private String causeDeces;
	private String nomCim;
	private String numTombe;
	private String numTel;
	@ManyToOne
	@JoinColumn(name="arrondissement_id")
	private Arrondissement arrondissement;

	@OneToMany(mappedBy = "obstacleDefunts", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<HistoriqueObstacel> historiqueObstacels;

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getDateDeclaration() {
		return dateDeclaration;
	}

	public void setDateDeclaration(LocalDate dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public LocalDate getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(LocalDate dateDeces) {
		this.dateDeces = dateDeces;
	}

	public LocalDate getDateConstation() {
		return dateConstation;
	}

	public void setDateConstation(LocalDate dateConstation) {
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

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public Constateur getConstateur() {
		return constateur;
	}

	public void setConstateur(Constateur constateur) {
		this.constateur = constateur;
	}

	public StatusCadavre getStatusCadavre() {
		return statusCadavre;
	}

	public void setStatusCadavre(StatusCadavre statusCadavre) {
		this.statusCadavre = statusCadavre;
	}

	public String getNomCim() {
		return nomCim;
	}

	public void setNomCim(String nomCim) {
		this.nomCim = nomCim;
	}

	public String getNumTombe() {
		return numTombe;
	}

	public void setNumTombe(String numTombe) {
		this.numTombe = numTombe;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getConstater() {
		return Constater;
	}

	public void setConstater(String constater) {
		Constater = constater;
	}
}
