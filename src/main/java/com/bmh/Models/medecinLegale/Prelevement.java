package com.bmh.Models.medecinLegale;

import com.bmh.Models.MedecinOperant;
import com.bmh.Models.Status;
import com.bmh.Models.TypeExamen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prelevement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name="statut_id")
	private Status status;
}
