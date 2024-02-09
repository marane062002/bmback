package com.bmh.Models.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NouveauNe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numEnregistrement;
	private LocalDateTime dateEnregistrement;
	private String nom;
	private String prenom;
	private String nomMere;
	private String prenomMere;
	private String cinMere;
	private String telMere;
	private String adresseResMere;
	private String nationaliteMere;
	private Integer poids;
	private String adresseAccouchement;
	private String natureAccouchement;
	private LocalDateTime dateAccouchement;
	private String observation;
	private String nomPere;
	private String prenomPere;
	private String cinPere;
	private String nationalitePere;
	private String telPere;
	private String statut;
	private String adresseResPere;
	private String nomSageFemme;
	private String prenomSageFemme;
	private String cinSageFemme;
	private LocalDate dateSageFemme;
	private String telSageFemme;
	private String adresseSageFemme;
	private String nomConstateur;
	private String prenomConstateur;
	private String cinConstateur;
	private Sexe sexe;
}
