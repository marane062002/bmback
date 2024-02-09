package com.bmh.Repositories;

import com.bmh.Models.TVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVaccationRepository extends JpaRepository<TVacation,Long> {
}
