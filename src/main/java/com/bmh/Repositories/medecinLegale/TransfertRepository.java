package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert,Long> {
}
