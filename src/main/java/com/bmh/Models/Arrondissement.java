package com.bmh.Models;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arrondissement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le libellé doit contenir uniquement des lettres.")
	private String libelle;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "La description doit contenir uniquement des lettres.")
	private String description;
	@OneToMany(mappedBy = "arrondissement")
	@JsonIgnore
	private List<DecesNaturel> decesNaturels;
	@OneToMany(mappedBy = "arrondissement")
	@JsonIgnore
	private List<EntrementInhumation> entrementInhumations;
}
