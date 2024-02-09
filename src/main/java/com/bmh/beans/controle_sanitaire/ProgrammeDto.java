package com.bmh.beans.controle_sanitaire;

import com.bmh.Models.controle_sanitaire.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class ProgrammeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String motifVisite;
    private Set<ListEtablissementDTO> listEtablissements;
    private Set<AgentDTO> agents;
    @JsonIgnoreProperties("programmeDto")
    private ConventionDTO convention;
    @JsonIgnoreProperties("programmeDto")
    private TypeAnalyseDTO typeAnalyse;

    @JsonIgnoreProperties("programmeDto")
    private SousTypeDTO sousType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotifVisite() {
        return motifVisite;
    }

    public void setMotifVisite(String motifVisite) {
        this.motifVisite = motifVisite;
    }

    public Set<ListEtablissementDTO> getListEtablissements() {
        return listEtablissements;
    }

    public void setListEtablissements(Set<ListEtablissementDTO> listEtablissements) {
        this.listEtablissements = listEtablissements;
    }

    public Set<AgentDTO> getAgents() {
        return agents;
    }

    public void setAgents(Set<AgentDTO> agents) {
        this.agents = agents;
    }

    public ConventionDTO getConvention() {
        return convention;
    }

    public void setConvention(ConventionDTO convention) {
        this.convention = convention;
    }

    public TypeAnalyseDTO getTypeAnalyse() {
        return typeAnalyse;
    }

    public void setTypeAnalyse(TypeAnalyseDTO typeAnalyse) {
        this.typeAnalyse = typeAnalyse;
    }

    public SousTypeDTO getSousType() {
        return sousType;
    }

    public void setSousType(SousTypeDTO sousType) {
        this.sousType = sousType;
    }
}
