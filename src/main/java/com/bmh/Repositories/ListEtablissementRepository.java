package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.ListEtablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListEtablissementRepository extends JpaRepository<ListEtablissement,Long> {
}
