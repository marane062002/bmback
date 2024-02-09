package com.bmh.Models.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Quartier;
import com.bmh.Models.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class EntrementInhumation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Sexe sexe;
	private Date dateEnterementObstacle;
	private String lieuEnterementObstacle;
	private String lieuRecuperationObstacle;
	private String pieceJointe;

	@OneToOne
	@JoinColumn(name = "origine_id")
	private Origine origine;

//	@OneToOne(mappedBy = "origine")
//	@JsonIgnoreProperties(value = "origine")
//	private EntrementInhumation entrementInhumation;

	@ManyToOne
	@JoinColumn(name = "commune_id")
	private Commune commune;

	@ManyToOne
	@JoinColumn(name="quartier_id")
	private Quartier quartier;
	@ManyToOne
	@JoinColumn(name="type_id")
	private Type type;
	@ManyToOne
	@JoinColumn(name="arrondissemnt_id")
	private Arrondissement arrondissement;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Date getDateEnterementObstacle() {
		return dateEnterementObstacle;
	}

	public void setDateEnterementObstacle(Date dateEnterementObstacle) {
		this.dateEnterementObstacle = dateEnterementObstacle;
	}

	public String getLieuEnterementObstacle() {
		return lieuEnterementObstacle;
	}

	public void setLieuEnterementObstacle(String lieuEnterementObstacle) {
		this.lieuEnterementObstacle = lieuEnterementObstacle;
	}

	public String getLieuRecuperationObstacle() {
		return lieuRecuperationObstacle;
	}

	public void setLieuRecuperationObstacle(String lieuRecuperationObstacle) {
		this.lieuRecuperationObstacle = lieuRecuperationObstacle;
	}

	public String getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(String pieceJointe) {
		this.pieceJointe = pieceJointe;
	}

	public Origine getOrigine() {
		return origine;
	}

	public void setOrigine(Origine origine) {
		this.origine = origine;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}
}
