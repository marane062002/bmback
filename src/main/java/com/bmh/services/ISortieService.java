package com.bmh.services;

import com.bmh.Models.Sortie;
import com.bmh.Models.controle_sanitaire.Programmes;
import com.bmh.beans.SortieDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ISortieService {
    Sortie add(SortieDTO sortieDTO);
    List<SortieDTO> getALl();
    SortieDTO getById(long id);

    SortieDTO update(long id, SortieDTO sortieDTO);
    void delete(long id);
    Page<SortieDTO> AllPagination(Pageable pageable);
}
