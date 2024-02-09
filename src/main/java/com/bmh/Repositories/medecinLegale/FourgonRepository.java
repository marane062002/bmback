package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FourgonRepository extends JpaRepository<Fourgon,Long> {
}
