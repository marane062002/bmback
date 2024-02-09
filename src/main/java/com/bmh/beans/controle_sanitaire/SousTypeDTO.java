package com.bmh.beans.controle_sanitaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousTypeDTO {
	private Long id;
	private String libelle;
	private String description;

}