package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeurRepository extends JpaRepository<Employeur,Long> {

}
