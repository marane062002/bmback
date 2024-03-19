package com.bmh.beans;

import com.bmh.Models.medecinLegale.DecesNaturel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrondissementDTO {
	private Long id;
	private String libelle;
	private String description;
	//private List<DecesNaturel> decesNaturels;
}
