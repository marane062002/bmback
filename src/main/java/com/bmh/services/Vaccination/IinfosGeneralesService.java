package com.bmh.services.Vaccination;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.Models.vaccination.InfosGenerales;
import com.bmh.beans.VaccinationDTO.InfosGeneralesDto;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IinfosGeneralesService {
    InfosGenerales add(InfosGeneralesDto infosGeneralesDto, MultipartFile pieceJointe);
    List<InfosGeneralesDto> getALl();
    InfosGeneralesDto getById(long id);
    void update(long id,InfosGeneralesDto infosGeneralesDto, MultipartFile pieceJointe);
    void delete(long id);
    Page<InfosGeneralesDto> AllPagination(Pageable pageable);
}
