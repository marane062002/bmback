package com.bmh.beans.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstateurNouveauNeDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String sexe;
}
