package com.bmh.Repositories;

import com.bmh.Models.Constateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConstateurRepository extends JpaRepository<Constateur,Long> {
}
