package com.bmh.beans.controle_sanitaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotBlank
    private String denomination;
    @NotBlank
    private String description;
    @NotBlank
    private String delaisReponse;
    @NotNull
    private Number note;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelaisReponse() {
        return delaisReponse;
    }

    public void setDelaisReponse(String delaisReponse) {
        this.delaisReponse = delaisReponse;
    }

    public Number getNote() {
        return note;
    }

    public void setNote(Number note) {
        this.note = note;
    }
}
