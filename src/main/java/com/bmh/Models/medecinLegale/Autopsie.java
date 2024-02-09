package com.bmh.Models.medecinLegale;

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
public class Autopsie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	@ManyToOne
	@JoinColumn(name="medecinOperant_id")
	private MedecinOperant medecinOperant;
	@ManyToOne
	@JoinColumn(name="statut_id")
	private Status status;
}
