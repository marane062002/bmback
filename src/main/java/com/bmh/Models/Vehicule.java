package com.bmh.Models;

import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.Models.medecinLegale.Fourgon;
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
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "Le libellé doit contenir uniquement des lettres.")
	private String libelle;
//	@Pattern(regexp ="^[a-zA-z]+$", message = "Le libellé doit contenir uniquement des lettres.")
	private String description;
	@OneToMany(mappedBy = "vehicule")
	@JsonIgnore
	private List<Fourgon> fourgon;
	@OneToMany(mappedBy = "vehicule")
	@JsonIgnore
	private List<Transfert> transfert;

}
