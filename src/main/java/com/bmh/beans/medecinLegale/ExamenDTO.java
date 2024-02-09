package com.bmh.beans.medecinLegale;

import com.bmh.Models.MedecinOperant;
import com.bmh.Models.Status;
import com.bmh.Models.TypeExamen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDTO {
	private Long id;
	private LocalDate date;
	private TypeExamen typeExamen;
	private MedecinOperant medecinOperant;
	private Status status;
}
