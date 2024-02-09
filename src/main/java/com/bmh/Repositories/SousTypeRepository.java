package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.SousType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousTypeRepository extends JpaRepository<SousType,Long> {
}
