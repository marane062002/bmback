package com.bmh.Models.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Constateur;
import com.bmh.Models.Enum.SexeCadavre;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.Quartier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
	private String numDeces;
	private String cause;
	private String descriptionDec;
	private String numRegistre;
	private StatusCadavre statusCadavre;
	private String nomCim;
	private String numTombe;
	@Column(name = "created_at")
	private Date createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@OneToMany(mappedBy = "decesNaturel", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<HistoriqueDeces> historiqueDeces;
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
