package com.bmh.beans.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Constateur;
import com.bmh.Models.Enum.SexeCadavre;
import com.bmh.Models.Quartier;
import com.bmh.Models.medecinLegale.Nationalite;
import com.bmh.Models.medecinLegale.Sexe;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.ConstateurDTO;
import com.bmh.beans.QuartierDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecesNaturelDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private LocalDate date;
	private SexeCadavre sexe;
	private String lieu;
	private String adresseResidence;
//	private String adresseDeces;
	private String nationalite;
	private String constater;
	private String descriptionDec;
	private String dateDeces;
	private String cause;
	private Constateur constateur;
	private Arrondissement arrondissement;
	private Quartier quartier;
	private Commune commune;
}
