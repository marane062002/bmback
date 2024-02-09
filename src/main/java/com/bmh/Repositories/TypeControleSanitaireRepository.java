package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.TypeControleSanitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeControleSanitaireRepository extends JpaRepository<TypeControleSanitaire,Long> {
}
