package com.bmh.beans.medecinLegale;

import com.bmh.Models.medecinLegale.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MorgueDTO {
	private Long id;
	private Integer numCasier;
	private Integer numDeces;
	private String PcJointe;
	private Statut status;
}
