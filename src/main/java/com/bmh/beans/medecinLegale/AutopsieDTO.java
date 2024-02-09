package com.bmh.beans.medecinLegale;

import com.bmh.Models.MedecinOperant;
import com.bmh.Models.Status;
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
public class AutopsieDTO {
	private Long id;
	private Date date;
	private MedecinOperant medecinOperant;
	private Status status;
}
 