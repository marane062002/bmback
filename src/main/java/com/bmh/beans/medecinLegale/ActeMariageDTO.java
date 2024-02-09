package com.bmh.beans.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActeMariageDTO {
	private Long id;
	private String nomPere;
	private String prenomPere;
	private String cinPere;
	private String nationalitePere;
	private String telPere;
	private  String Statut;
	private String adresseResPere;
}
