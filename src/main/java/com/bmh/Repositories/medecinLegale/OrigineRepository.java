package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Origine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigineRepository extends JpaRepository<Origine,Long> {
}
