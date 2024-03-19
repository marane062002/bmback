package com.bmh.specification;

import com.bmh.Models.controle_sanitaire.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EtablissementSpecification implements Specification<Etablissement> {


    private final SearchEtablissement searchEtablissement;


    public EtablissementSpecification(SearchEtablissement searchEtablissement) {
        this.searchEtablissement = searchEtablissement;
    }


    @Override
    public Specification<Etablissement> and(Specification<Etablissement> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Etablissement> or(Specification<Etablissement> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Etablissement> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        Predicate predicate = builder.conjunction();


//        if (searchEtablissement.getDateDebut() != null) {
//            predicates.add(builder.greaterThanOrEqualTo(root.get("date"), searchEtablissement.getDateDebut()));
//        }
//        if (searchEtablissement.getDateFin() != null) {
//            predicates.add(builder.lessThanOrEqualTo(root.get("dateFin"), searchEtablissement.getDateFin()));
//        }

        if (searchEtablissement.getDateDebut()!=null && searchEtablissement.getDateFin()!=null  ) {
            Predicate p = builder.between(root.get("date"), searchEtablissement.dateDebut,searchEtablissement.dateFin);
            predicates.add(p);

        }


        query.where(builder.and(predicates.toArray(new Predicate[0])));
        query.distinct(true);
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
