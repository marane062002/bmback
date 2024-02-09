package com.bmh.Repositories.Vaccination;

import com.bmh.Models.vaccination.InfosGenerales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfosGeneralesRepository extends JpaRepository<InfosGenerales,Long> {
}
