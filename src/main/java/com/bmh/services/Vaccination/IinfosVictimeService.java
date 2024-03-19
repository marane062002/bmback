package com.bmh.services.Vaccination;

import com.bmh.Models.vaccination.InfosVictime;
import com.bmh.beans.VaccinationDTO.InfosVictimeDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IinfosVictimeService {
    InfosVictime add(InfosVictimeDto infosVictimeDto);
    List<InfosVictimeDto> getALl();
    InfosVictimeDto getById(long id);
    InfosVictime update(long id,InfosVictimeDto infosVictimeDto );
    void delete(long id);
//    Page<InfosVictimeDto> AllPagination(Pageable pageable);
}
