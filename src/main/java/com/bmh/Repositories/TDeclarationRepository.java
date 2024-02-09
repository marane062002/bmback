package com.bmh.Repositories;

import com.bmh.Models.TDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TDeclarationRepository extends JpaRepository<TDeclaration,Long> {
}
