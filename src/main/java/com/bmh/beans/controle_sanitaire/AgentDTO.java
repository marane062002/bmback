package com.bmh.beans.controle_sanitaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String tel;
}
