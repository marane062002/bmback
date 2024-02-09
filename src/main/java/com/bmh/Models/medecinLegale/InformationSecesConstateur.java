package com.bmh.Models.medecinLegale;

import com.bmh.Models.Constateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InformationSecesConstateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateDeces;
	private LocalDateTime dateConstation;
	private String causesDeces;
	@ManyToOne
	@JoinColumn(name="constateur_id")
	private Constateur constateur;
}
