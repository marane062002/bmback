package com.bmh.Models.controle_sanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.Programmes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Morale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String rs;
    private String rc;

}
