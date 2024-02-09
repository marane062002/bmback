package com.bmh.beans.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationsDeclarantsDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String qualite;
	private LocalDateTime date;
}
