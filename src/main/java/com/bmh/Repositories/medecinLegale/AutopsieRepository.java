package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Autopsie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutopsieRepository extends JpaRepository<Autopsie,Long> {
}
