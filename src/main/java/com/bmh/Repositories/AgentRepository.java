package com.bmh.Repositories;

import com.bmh.Models.controle_sanitaire.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
