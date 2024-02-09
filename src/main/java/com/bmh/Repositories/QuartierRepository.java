package com.bmh.Repositories;

import com.bmh.Models.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartierRepository extends JpaRepository<Quartier,Long> {
}
