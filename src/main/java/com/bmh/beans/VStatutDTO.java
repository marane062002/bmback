package com.bmh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VStatutDTO {
	private Long id;
	private String libelle;
	private String description;
}
