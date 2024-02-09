package com.bmh.Repositories;

import com.bmh.Models.MedecinOperant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedecinOperantRepository extends JpaRepository<MedecinOperant,Long> {
}
