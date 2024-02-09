package com.bmh.Models.vaccination;

import com.bmh.Models.*;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class InfosGenerales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateTraitement;
    private Date dateMorsure;
    private String lieuMorsure;
    private Number nbrAnimauxCapture;
    private String description;
    private String pieceJointe;
    @ManyToOne
    @JoinColumn(name = "tvacation_id")
    private TVacation tVacation;
    @ManyToOne
    @JoinColumn(name = "declaration_id")
    private TDeclaration declaration;
    @ManyToOne
    @JoinColumn(name = "traitEffect_id")
    private TraitEffect traitEffect;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;


    @OneToOne
    @JoinColumn(name = "infosVictime_id")
    private InfosVictime infosVictime;

    @OneToOne
    @JoinColumn(name = "typeAnimal_id")
    private TypeAnimal typeAnimal;

    public InfosVictime getInfosVictime() {
        return infosVictime;
    }

    public void setInfosVictime(InfosVictime infosVictime) {
        this.infosVictime = infosVictime;
    }

    public TypeAnimal getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(TypeAnimal typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public Date getDateMorsure() {
        return dateMorsure;
    }

    public void setDateMorsure(Date dateMorsure) {
        this.dateMorsure = dateMorsure;
    }

    public String getLieuMorsure() {
        return lieuMorsure;
    }

    public void setLieuMorsure(String lieuMorsure) {
        this.lieuMorsure = lieuMorsure;
    }

    public Number getNbrAnimauxCapture() {
        return nbrAnimauxCapture;
    }

    public void setNbrAnimauxCapture(Number nbrAnimauxCapture) {
        this.nbrAnimauxCapture = nbrAnimauxCapture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public TVacation gettVacation() {
        return tVacation;
    }

    public void settVacation(TVacation tVacation) {
        this.tVacation = tVacation;
    }

    public TDeclaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(TDeclaration declaration) {
        this.declaration = declaration;
    }

    public TraitEffect getTraitEffect() {
        return traitEffect;
    }

    public void setTraitEffect(TraitEffect traitEffect) {
        this.traitEffect = traitEffect;
    }
}
