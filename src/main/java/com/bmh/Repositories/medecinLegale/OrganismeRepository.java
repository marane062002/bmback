package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismeRepository extends JpaRepository<Organisme,Long> {
}
