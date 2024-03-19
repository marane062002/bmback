
package com.bmh.Models.controle_sanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Controleur;
import com.bmh.Models.Enum.Personne;
import com.bmh.Models.Quartier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.lang.String;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String denomination;
    private NatureEtablissement natureEtablissement;
    private String remarque;
    private MesuresPrises mesuresPrises;

    private SaisisDestruction saisisDestruction;
    private Double valeurSaisieDestruction;

    private EtatHygiene etatHygiene;
    private boolean controleEffectue = true;

    private String tel;
    private String adresse;
    @Enumerated(EnumType.STRING)
    @Column(name = "personne")
    private Personne personne;
    private ProprGerant proprGerant;
    private String nomProp;
    private String prenomProp;
    private String cinPro;
    private String nomGerant;
    private String prenomGerant;
    private String cinGerant;
    private String rc;
    private Date date;

    @Column(name = "created_at")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeControleSanitaire typeControleSanitaire;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;

    @ManyToOne
    @JoinColumn(name = "arrondissement_id")
    private Arrondissement arrondissement;

    @ManyToOne
    @JoinColumn(name = "quartier_id")
    private Quartier quartier;
    @ManyToOne
    @JoinColumn(name = "controleur_id")
    private Controleur controleur;


}


   /* public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIfiscal() {
        return ifiscal;
    }

    public void setIfiscal(String ifiscal) {
        this.ifiscal = ifiscal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomProp() {
        return nomProp;
    }

    public void setNomProp(String nomProp) {
        this.nomProp = nomProp;
    }

    public String getPrenomProp() {
        return prenomProp;
    }

    public void setPrenomProp(String prenomProp) {
        this.prenomProp = prenomProp;
    }

    public String getCinPro() {
        return cinPro;
    }

    public void setCinPro(String cinPro) {
        this.cinPro = cinPro;
    }

    public String getTelProp() {
        return telProp;
    }

    public void setTelProp(String telProp) {
        this.telProp = telProp;
    }

    public String getNomGerant() {
        return nomGerant;
    }

    public void setNomGerant(String nomGerant) {
        this.nomGerant = nomGerant;
    }

    public String getPrenomGerant() {
        return prenomGerant;
    }

    public void setPrenomGerant(String prenomGerant) {
        this.prenomGerant = prenomGerant;
    }

    public String getCinGerant() {
        return cinGerant;
    }

    public void setCinGerant(String cinGerant) {
        this.cinGerant = cinGerant;
    }

    public String getTelGerant() {
        return telGerant;
    }

    public void setTelGerant(String telGerant) {
        this.telGerant = telGerant;
    }

    public TypeControleSanitaire getTypeControleSanitaire() {
        return typeControleSanitaire;
    }

    public void setTypeControleSanitaire(TypeControleSanitaire typeControleSanitaire) {
        this.typeControleSanitaire = typeControleSanitaire;
    }

    public SousType getSousType() {
        return sousType;
    }

    public void setSousType(SousType sousType) {
        this.sousType = sousType;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }*/
