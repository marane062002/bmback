package com.bmh.Models;

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
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le nom doit contenir uniquement des lettres.")
	private String nom;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le nom doit contenir uniquement des lettres.")
	private String prenom;
	private String cin;
	private String tel;
}
