package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
