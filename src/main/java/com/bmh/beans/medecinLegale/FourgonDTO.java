package com.bmh.beans.medecinLegale;

import com.bmh.Models.Vehicule;
import com.bmh.Models.medecinLegale.Organisme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FourgonDTO {
	private Long id;
	private String matricule;
	private String couleur;
	private String pcj;
	private Organisme organisme;
	private Vehicule vehicule;
}
