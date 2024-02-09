package com.bmh.beans;

import com.bmh.Models.medecinLegale.DecesNaturel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstateurDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String tel;
	private List<DecesNaturel> decesNaturels;
}
