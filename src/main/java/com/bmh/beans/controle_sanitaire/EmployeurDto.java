package com.bmh.beans.controle_sanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeurDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String raisonSocial;
    @NotBlank
    private String idFiscal;
    @NotBlank
    private String taxe;
    @NotBlank
    private String numeroAutorisation;

    private Number nombreEmployes;

    @NotBlank
    private String ice;
    @NotBlank
    private String tel;
    @NotBlank
    private String fax;
    @NotBlank
    private String email;
    @NotBlank
    private String adresse;
//    @NotBlank
//    private String pieceJointes;

    @JsonIgnoreProperties(value = "employeurDto")
    private EmployeDto employe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(String idFiscal) {
        this.idFiscal = idFiscal;
    }



    public String getTaxe() {
        return taxe;
    }

    public void setTaxe(String taxe) {
        this.taxe = taxe;
    }

    public String getNumeroAutorisation() {
        return numeroAutorisation;
    }

    public void setNumeroAutorisation(String numeroAutorisation) {
        this.numeroAutorisation = numeroAutorisation;
    }


    public Number getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(Number nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

//    public String getPieceJointes() {
//        return pieceJointes;
//    }
//
//    public void setPieceJointes(String pieceJointes) {
//        this.pieceJointes = pieceJointes;
//    }

    public EmployeDto getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDto employe) {
        this.employe = employe;
    }
}
