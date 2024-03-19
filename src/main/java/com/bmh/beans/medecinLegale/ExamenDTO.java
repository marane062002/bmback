package com.bmh.beans.medecinLegale;

import com.bmh.Models.MedecinOperant;
import com.bmh.Models.Status;
import com.bmh.Models.TypeExamen;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDTO {
	private Long id;
	private LocalDate date;
	private TypeExamen typeExamen;
	private MedecinOperant medecinOperant;
	private ObstacleDefunts obstacleDefunts;
	private Status status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date createdAt;
}
