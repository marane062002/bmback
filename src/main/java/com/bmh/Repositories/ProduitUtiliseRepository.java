package com.bmh.Repositories;

import com.bmh.Models.ProduitUtilise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitUtiliseRepository extends JpaRepository<ProduitUtilise,Long> {
}
