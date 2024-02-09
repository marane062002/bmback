package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRepositoy extends JpaRepository<Decision,Long> {
}
