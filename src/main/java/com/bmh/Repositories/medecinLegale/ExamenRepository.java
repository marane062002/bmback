package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen,Long> {
}
