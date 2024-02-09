package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.EntrementInhumation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrementInhumationRepository extends JpaRepository<EntrementInhumation,Long> {
}
