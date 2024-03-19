package com.bmh.beans.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Constateur;
import com.bmh.Models.Enum.SexeCadavre;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.Quartier;
import com.bmh.Models.medecinLegale.Nationalite;
import com.bmh.Models.medecinLegale.Sexe;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.ConstateurDTO;
import com.bmh.beans.QuartierDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

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
	private String numDeces;
	private String constater;
	private String descriptionDec;
	private String dateDeces;
	private String numRegistre;
	private String cause;
	private Constateur constateur;
	private Arrondissement arrondissement;
	private Quartier quartier;
	private Commune commune;
    private StatusCadavre statusCadavre;
	private String nomCim;
	private String numTombe;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date createdAt;
}
