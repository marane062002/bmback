package com.bmh.Repositories;

import com.bmh.Models.TypeTraitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTraitementRepository extends JpaRepository<TypeTraitement,Long> {
}
