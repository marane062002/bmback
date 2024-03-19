package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Repositories.carteSanitaire.EtablissementRepository;
import com.bmh.services.carteSanitaire.ISpecifEtablissementService;
import com.bmh.specification.EtablissementSpecification;
import com.bmh.specification.SearchEtablissement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class SpecificationServiceImpl implements ISpecifEtablissementService {

    private final EtablissementRepository etablissementRepository;

    public SpecificationServiceImpl(EtablissementRepository etablissementRepository) {
        this.etablissementRepository = etablissementRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Etablissement> findSpecification(SearchEtablissement searchCriteria) {
        EtablissementSpecification appleSpecification = new EtablissementSpecification(searchCriteria);
        List<Etablissement> audits = etablissementRepository.findAll(appleSpecification);
        return audits;
    }
}
