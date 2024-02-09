package com.bmh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjetSortieDTO {
	private Long id;
	private String libelle;
	private String description;
}
