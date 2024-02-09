package com.bmh.beans.medecinLegale;

import com.bmh.Models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrelevementDTO {
	private Long id;
	private LocalDate date;
	private Status status;
}
