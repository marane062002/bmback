package com.bmh.Repositories.carteSanitaire.PersonnesEtabRepository;

import com.bmh.Models.controle_sanitaire.PersonnesEtab.Morale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoraleRepository extends JpaRepository<Morale,Long> {
}
