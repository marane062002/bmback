package com.bmh.Repositories;

import com.bmh.Models.TypeExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeExamenRepository extends JpaRepository<TypeExamen,Long> {
}
