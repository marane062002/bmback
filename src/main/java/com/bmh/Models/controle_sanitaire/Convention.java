package com.bmh.Models.controle_sanitaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Convention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le libellé doit contenir uniquement des lettres.")
	private String libelle;
	@Pattern(regexp = "^[a-zA-Z]+$", message = "La description doit contenir uniquement des lettres.")
	private String description;
}
