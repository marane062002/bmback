package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.ConstateurNouveauNe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstateurNouveauNeRepository extends JpaRepository<ConstateurNouveauNe,Long> {
}
