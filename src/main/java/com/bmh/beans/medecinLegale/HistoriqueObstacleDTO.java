package com.bmh.beans.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueObstacleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nouveauStatut;
    private ObstacleDefunts obstacleDefunts;
    @JsonFormat(shape = JsonFormat.Shape.STRING , timezone = "UTC")
    private Date updatedAt;
}
