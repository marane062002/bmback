package com.bmh.Models;

import com.bmh.Models.medecinLegale.Cadavre;
import com.bmh.Models.medecinLegale.Transfert;
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
public class Conducteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le nom doit contenir uniquement des lettres.")
	private String nom;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le nom doit contenir uniquement des lettres.")
	private String prenom;
	private String cin;
	private String tel;

	@OneToMany(mappedBy = "conducteur")
	@JsonIgnore
	private List<Transfert> transfert;

	@OneToMany(mappedBy = "conducteur")
	private List<Cadavre> cadavre;

}
