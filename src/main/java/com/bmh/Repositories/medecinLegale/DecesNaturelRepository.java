package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecesNaturelRepository extends JpaRepository<DecesNaturel,Long> {
}
