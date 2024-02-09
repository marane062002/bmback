package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.ActeMariage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeMariageRepository extends JpaRepository<ActeMariage,Long> {
}
