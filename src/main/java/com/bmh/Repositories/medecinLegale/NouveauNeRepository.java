package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.NouveauNe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NouveauNeRepository extends JpaRepository<NouveauNe,Long> {
}
