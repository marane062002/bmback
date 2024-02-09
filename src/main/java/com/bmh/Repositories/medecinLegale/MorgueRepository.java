package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Morgue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MorgueRepository extends JpaRepository<Morgue,Long> {
}
