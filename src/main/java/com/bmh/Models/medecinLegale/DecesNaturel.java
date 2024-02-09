package com.bmh.Models.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Constateur;
import com.bmh.Models.Enum.SexeCadavre;
import com.bmh.Models.Quartier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecesNaturel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String nationalite;
	private LocalDate date;
	private SexeCadavre sexe;
	private String constater;
	private String dateDeces;
	private String cause;
    private String descriptionDec;
	@ManyToOne
	@JoinColumn(name="arrondissement_id")
	private Arrondissement arrondissement;

	@ManyToOne
	@JoinColumn(name = "commune_id") // Nom de la colonne faisant référence à la commune
	private Commune commune;

	@ManyToOne
	@JoinColumn(name="quartier_id")
	private Quartier quartier;

	private String lieu;
	private String adresseResidence;

	@ManyToOne
	@JoinColumn(name="constateur_id")
	private Constateur constateur;

//	private String adresseDeces;
}
