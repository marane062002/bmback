package com.bmh.Models.medecinLegale;

import com.bmh.Models.Conducteur;
import com.bmh.Models.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pointDepart;
	private String pointArrive;
	private String lieuInhumation;
	private Integer numBulletin;
	private String remarque;
	@ManyToOne
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule;
	@ManyToOne
	@JoinColumn(name="conducteur_id")
	private Conducteur conducteur;
}
