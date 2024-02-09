package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Programmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programmes,Long> {
}
