package com.bmh.Repositories.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {
}
