package com.bmh.beans.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SageFemmeDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private LocalDate date;
	private String tel;
	private String adresse;

}
