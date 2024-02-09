package com.bmh.Repositories;

import com.bmh.Models.Arrondissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrondissementRepository extends JpaRepository<Arrondissement,Long> {
}
