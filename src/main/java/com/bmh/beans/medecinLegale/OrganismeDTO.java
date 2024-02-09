package com.bmh.beans.medecinLegale;

import com.bmh.Models.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganismeDTO {
	private Long id;
	private String raisonSociale;
	private String rc;
	private String ice;
	private String adresse;
	private String IFf;
	private String tel;
	private Type type;
}
