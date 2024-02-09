package com.bmh.Models.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActeMariage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomPere;
	private String prenomPere;
	private String cinPere;
	private String nationalitePere;
	private String telPere;
	private  String Statut;
	private String adresseResPere;
}
