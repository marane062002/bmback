package com.bmh.Models.medecinLegale;

import com.bmh.Models.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fourgon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String couleur;
	private String pcj;
	@ManyToOne
	@JoinColumn(name="organisme_id")
	private Organisme organisme;
	@ManyToOne
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule;
	@OneToMany(mappedBy = "fourgon")
	private List<Cadavre> cadavre;

}
