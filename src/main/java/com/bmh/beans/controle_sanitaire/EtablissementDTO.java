
package com.bmh.beans.controle_sanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Controleur;
import com.bmh.Models.Enum.Personne;
import com.bmh.Models.Quartier;
import com.bmh.Models.controle_sanitaire.*;
import com.bmh.Models.controle_sanitaire.PersonnesEtab.Morale;
import com.bmh.Models.controle_sanitaire.PersonnesEtab.Physique;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.QuartierDTO;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.MoraleDto;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.PhysiqueDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import java.lang.String;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtablissementDTO {

    private Long Id;
    private String denomination;
    private NatureEtablissement natureEtablissement;
    private String remarque;
    private MesuresPrises mesuresPrises;
    private SaisisDestruction saisisDestruction;
    private Double valeurSaisieDestruction;
    private EtatHygiene etatHygiene;
    private Boolean controleEffectue = true;

    private String tel;

    private String adresse;
    private Personne personne;
    private ProprGerant proprGerant;
    private String nomProp;
    private String prenomProp;
    private String cinPro;
    private String nomGerant;
    private String prenomGerant;
    private String cinGerant;
    private String rc;
    private TypeControleSanitaire typeControleSanitaire;



    private Commune commune;
    private Arrondissement arrondissement;
    private Quartier quartier;
    private Controleur controleur;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date createdAt;

    private Date date;
//    @PrePersist
//    protected void onCreate() {
//        date = new Date();
//    }



}


