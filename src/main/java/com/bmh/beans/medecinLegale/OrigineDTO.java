package com.bmh.beans.medecinLegale;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigineDTO {
//	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private Date date;
	private String cin;
	private Integer numBulletin;
	private String nationalite;
	private Boolean connu;
//	@JsonIdentityReference(alwaysAsId = true)
	@JsonIgnoreProperties(value = "origine",  allowSetters = true)
	private EntrementInhumationDTO entrementInhumation;
}
