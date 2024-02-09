package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Prelevement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrelevementRepository extends JpaRepository<Prelevement,Long> {
}
