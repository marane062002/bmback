package com.bmh.Models.medecinLegale;

import com.bmh.Models.Type;
import com.bmh.Models.Vehicule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rc;
	private String raisonSociale;
	private String ice;
	private String adresse;
	private String IFf;
	private String tel;
	@ManyToOne
	@JoinColumn(name="type_id")
	private Type type;
	@OneToMany(mappedBy = "organisme")
	@JsonIgnore
	private List<Fourgon> fourgon;
}
