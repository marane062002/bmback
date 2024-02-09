package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.SageFemme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SageFemmeRepository extends JpaRepository<SageFemme,Long> {
}
