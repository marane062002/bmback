package com.bmh.Models.medecinLegale;

import com.bmh.Models.Constateur;
import com.bmh.Models.MedecinOperant;
import com.bmh.Models.Status;
import com.bmh.Models.TypeExamen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	@Column(name = "created_at")
	private Date createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@ManyToOne
	@JoinColumn(name="typeExamen_id")
	private TypeExamen typeExamen;
	@ManyToOne
	@JoinColumn(name="medecinOperant_id")
	private MedecinOperant medecinOperant;

	@ManyToOne
	@JoinColumn(name="obstacleDefunts_id")
	private ObstacleDefunts obstacleDefunts;

	@ManyToOne
	@JoinColumn(name="statut_id")
	private Status status;
}
