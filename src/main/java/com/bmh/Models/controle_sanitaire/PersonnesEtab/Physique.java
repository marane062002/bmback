package com.bmh.Models.controle_sanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.Programmes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Physique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nom;
    private String prenom;
    private String cin;

}
