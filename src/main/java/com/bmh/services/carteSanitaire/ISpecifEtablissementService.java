package com.bmh.services.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.specification.SearchEtablissement;

import java.util.List;

public interface ISpecifEtablissementService {
    List<Etablissement> findSpecification(SearchEtablissement searchCriteria);

}
