package com.bmh.beans;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommuneDTO {
	private Long id;
	private String libelle;
	private String description;
	//private List<DecesNaturelDTO> decesNaturels;
	private List<EntrementInhumation> entrementInhumations;
}
