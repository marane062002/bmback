package com.bmh.Models.medecinLegale;

import com.bmh.Models.Conducteur;
import com.bmh.Models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cadavre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime date;
	private String observation;
	private String statut;
	private Boolean autorizationProcureur;
	private ConducteurObstacle conducteurObstacle;
	private String nom;
	private String prenom;
	private String tel;
	private String cin;
	@ManyToOne
	@JoinColumn(name="obstacle_id")
	private ObstacleDefunts obstacleDefunts;
	@ManyToOne
	@JoinColumn(name = "fourgon_id")
	private Fourgon fourgon;
	@ManyToOne
	@JoinColumn(name = "conducteur_id")
	private Conducteur conducteur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Boolean getAutorizationProcureur() {
		return autorizationProcureur;
	}

	public void setAutorizationProcureur(Boolean autorizationProcureur) {
		this.autorizationProcureur = autorizationProcureur;
	}

	public com.bmh.Models.medecinLegale.ConducteurObstacle getConducteurObstacle() {
		return conducteurObstacle;
	}

	public void setConducteurObstacle(com.bmh.Models.medecinLegale.ConducteurObstacle conducteurObstacle) {
		this.conducteurObstacle = conducteurObstacle;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public ObstacleDefunts getObstacleDefunts() {
		return obstacleDefunts;
	}

	public void setObstacleDefunts(ObstacleDefunts obstacleDefunts) {
		this.obstacleDefunts = obstacleDefunts;
	}

	public com.bmh.Models.medecinLegale.Fourgon getFourgon() {
		return fourgon;
	}

	public void setFourgon(com.bmh.Models.medecinLegale.Fourgon fourgon) {
		this.fourgon = fourgon;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
}
