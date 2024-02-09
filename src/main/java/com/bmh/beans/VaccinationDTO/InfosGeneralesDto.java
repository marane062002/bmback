package com.bmh.beans.VaccinationDTO;

import com.bmh.Models.Animal;
import com.bmh.Models.TDeclaration;
import com.bmh.Models.TVacation;
import com.bmh.Models.TraitEffect;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.beans.medecinLegale.OrigineDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class InfosGeneralesDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateTraitement;
    private Date dateMorsure;
    private String lieuMorsure;
    private Number nbrAnimauxCapture;
    private String description;
    private String pieceJointe;
    @JsonIgnoreProperties(value = "infosGenerales")
    private TVacation tVacation;
    @JsonIgnoreProperties(value = "infosGenerales")
    private TDeclaration declaration;
    @JsonIgnoreProperties(value = "infosGenerales")
    private TraitEffect traitEffect;
    @JsonIgnoreProperties(value = "infosGenerales")
    private Animal animal;
    @JsonIgnoreProperties(value = "infosGenerales", allowSetters = true)
    private TypeAnimalDto typeAnimal;
    @JsonIgnoreProperties(value = "infosGenerales", allowSetters = true)
    private InfosVictimeDto infosVictime;



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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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

    public TypeAnimalDto getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(TypeAnimalDto typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public InfosVictimeDto getInfosVictime() {
        return infosVictime;
    }

    public void setInfosVictime(InfosVictimeDto infosVictime) {
        this.infosVictime = infosVictime;
    }
}
