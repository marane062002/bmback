package com.bmh.beans.medecinLegale;

import com.bmh.Models.Constateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationSecesConstateurDTO {
	private Long id;
	private LocalDateTime dateDeces;
	private LocalDateTime dateConstation;
	private String causesDeces;
	private Constateur constateur;
}
