package com.bmh.Repositories;

import com.bmh.Models.ObjetSortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetSortieRepository extends JpaRepository<ObjetSortie,Long> {
}
