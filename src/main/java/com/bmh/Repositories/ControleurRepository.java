package com.bmh.Repositories;

import com.bmh.Models.Controleur;
import org.docx4j.wml.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleurRepository extends JpaRepository<Controleur, Long> {
}
