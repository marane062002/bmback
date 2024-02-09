package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.Convention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConventionRepository extends JpaRepository<Convention,Long> {
}
