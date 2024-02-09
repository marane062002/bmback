package com.bmh.services.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Programmes;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProgrammeService {
    Programmes add(ProgrammeDto programmeDto);
    List<ProgrammeDto> getALl();
    ProgrammeDto getById(long id);
    void update(long id,ProgrammeDto programmeDto);
    void delete(long id);
    Page<ProgrammeDto> AllPagination(Pageable pageable);
}
