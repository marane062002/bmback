package com.bmh.Models.medecinLegale;

import com.bmh.Models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Morgue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numCasier;
	private Integer numDeces;
	private String PcJointe;
	private Statut status;
}
