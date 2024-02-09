package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.TypeAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAnalyseRepository extends JpaRepository<TypeAnalyse,Long> {
}
