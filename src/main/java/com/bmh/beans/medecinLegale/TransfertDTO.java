package com.bmh.beans.medecinLegale;

import com.bmh.Models.Conducteur;
import com.bmh.Models.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransfertDTO {
	private Long id;
	private String pointDepart;
	private String pointArrive;
	private String lieuInhumation;
	private Integer numBulletin;
	private String remarque;
	private Vehicule vehicule;
	private Conducteur conducteur;
}
