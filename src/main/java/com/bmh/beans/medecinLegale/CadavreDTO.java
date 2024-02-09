package com.bmh.beans.medecinLegale;

import com.bmh.Models.Conducteur;
import com.bmh.Models.medecinLegale.ConducteurObstacle;
import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadavreDTO {
	private Long id;
	private LocalDateTime date;
	private String observation;
	private String statut;
	private ConducteurObstacle conducteurObstacle;
	private Conducteur conducteur;
	private Boolean autorizationProcureur;
	private ObstacleDefunts obstacleDefunts;
	private Fourgon fourgon;
	private String nom;
	private String prenom;
	private String tel;
	private String cin;


}
