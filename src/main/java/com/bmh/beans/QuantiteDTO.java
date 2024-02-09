package com.bmh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantiteDTO {
	private Long id;
	private String libelle;
	private String description;
}