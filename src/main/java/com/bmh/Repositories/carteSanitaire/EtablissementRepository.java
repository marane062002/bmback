package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

}
