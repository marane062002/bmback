package com.bmh.Models.medecinLegale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Origine {
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
	@OneToOne(mappedBy = "origine")
	@JsonIgnoreProperties(value = "origine")
	private EntrementInhumation entrementInhumation;

}
