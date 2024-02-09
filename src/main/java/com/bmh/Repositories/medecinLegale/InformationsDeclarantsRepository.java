package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.InformationsDeclarants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationsDeclarantsRepository extends JpaRepository<InformationsDeclarants,Long> {
}
