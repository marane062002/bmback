package com.bmh.beans.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Quartier;
import com.bmh.Models.Type;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.Models.medecinLegale.Sexe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterrementObstacleDTO {
	private Long id;
	private Sexe sexe;
	private LocalDate dateEnterementObstacle;
	private String lieuEnterementObstacle;
	private String lieuRecuperationObstacle;
	private Commune commune;
	private Quartier quartier;
	private Type type;
	private Arrondissement arrondissement;
}
