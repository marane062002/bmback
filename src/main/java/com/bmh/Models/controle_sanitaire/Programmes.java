package com.bmh.Models.controle_sanitaire;

import com.bmh.Models.Equipe;
import com.bmh.Models.Type;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Programmes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private String motifVisite;

    @ManyToMany
    @JoinTable(
            name = "programme_etab",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "etablissement_id")
    )
    private Set<ListEtablissement> listEtablissements = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "programme_agent",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id")
    )
    private Set<Agent> agents = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "conventions_id" , unique = false)
    private Convention convention;

    @ManyToOne
    @JoinColumn(name = "types_id",unique = false)
    private TypeAnalyse typeAnalyse;

    @ManyToOne
    @JoinColumn(name = "sousTypes_id", unique = false)
    private SousType sousType;

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

    public Set<ListEtablissement> getListEtablissements() {
        return listEtablissements;
    }

    public void setListEtablissements(Set<ListEtablissement> listEtablissements) {
        this.listEtablissements = listEtablissements;
    }

    public Set<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Set<Agent> agents) {
        this.agents = agents;
    }

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

    public TypeAnalyse getTypeAnalyse() {
        return typeAnalyse;
    }

    public void setTypeAnalyse(TypeAnalyse typeAnalyse) {
        this.typeAnalyse = typeAnalyse;
    }

    public SousType getSousType() {
        return sousType;
    }

    public void setSousType(SousType sousType) {
        this.sousType = sousType;
    }
}
