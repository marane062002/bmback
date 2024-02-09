package com.bmh.specification;

import com.bmh.Models.Test;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TestSpecification implements Specification<Test> {


    @Override
    public Specification<Test> and(Specification<Test> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Test> or(Specification<Test> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Test> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
