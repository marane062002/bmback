package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.specification.SearchEtablissement;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtablissementSpecificationRepository extends JpaRepository<Etablissement,Long> {
    List<Etablissement> findAll(Specification<Etablissement> spec);

}
