package com.bmh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeExamenDTO {
	private Long id;
	private String libelle;
	private String description;
}
