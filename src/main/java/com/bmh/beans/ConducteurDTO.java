package com.bmh.beans;

import com.bmh.Models.Conducteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConducteurDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String tel;
}
