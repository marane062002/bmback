package com.bmh.Repositories.Vaccination;

import com.bmh.Models.vaccination.InfosVictime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfosVictimeRepository extends JpaRepository<InfosVictime,Long> {
}
