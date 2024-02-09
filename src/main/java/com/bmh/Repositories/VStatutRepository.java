package com.bmh.Repositories;

import com.bmh.Models.VctStatut;
import com.bmh.beans.VStatutDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VStatutRepository extends JpaRepository<VctStatut,Long> {
}
