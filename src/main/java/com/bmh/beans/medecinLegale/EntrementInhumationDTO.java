package com.bmh.beans.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Quartier;
import com.bmh.Models.Type;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.Models.medecinLegale.Origine;
import com.bmh.Models.medecinLegale.Sexe;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.QuartierDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrementInhumationDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Sexe sexe;
	private Date dateEnterementObstacle;
	private String lieuEnterementObstacle;
	private String lieuRecuperationObstacle;
	private String pieceJointe;

//	@JsonIgnoreProperties(value = "entrementInhumation",  allowSetters = true)
	private Origine origine;

//	@JsonIgnoreProperties(value = "entrementInhumationDto")
	private Commune commune;

//	@JsonIgnoreProperties(value = "entrementInhumationDto")
	private Quartier quartier;

//	@JsonIgnoreProperties(value = "entrementInhumationDto")
	private Type type;

//	@JsonIgnoreProperties(value = "entrementInhumationDto")
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}
}
