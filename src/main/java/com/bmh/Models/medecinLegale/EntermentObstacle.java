package com.bmh.Models.medecinLegale;

import com.bmh.Models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntermentObstacle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Sexe sexe;
	private LocalDate dateEnterementObstacle;
	private String lieuEnterementObstacle;
	private String lieuRecuperationObstacle;
	@ManyToOne
	@JoinColumn(name = "commune_id") // Nom de la colonne faisant référence à la commune
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

}
