package com.bmh.Repositories.medecinLegale;

import com.bmh.Models.medecinLegale.InformationSecesConstateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationSecesConstateurRepository extends JpaRepository<InformationSecesConstateur,Long> {
}
