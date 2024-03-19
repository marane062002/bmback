package com.bmh.beans.medecinLegale;

import com.bmh.Models.Enum.AnalyseTypes;
import com.bmh.Models.Status;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrelevementDTO {
	private Long id;
	private LocalDate date;
	private Status status;
	private AnalyseTypes analyseTypes;
	private ObstacleDefunts obstacleDefunts;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date createdAt;
}
