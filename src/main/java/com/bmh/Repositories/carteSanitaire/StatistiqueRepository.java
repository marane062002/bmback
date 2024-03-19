package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatistiqueRepository extends JpaRepository<Statistique,Long> {

}
