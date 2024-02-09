package com.bmh.services.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEmployeur {
    Employeur add(EmployeurDto employeurDto, MultipartFile pieceJointes);
    List<EmployeurDto> getALl();
    EmployeurDto getById(long id);
    void update(long id,EmployeurDto employeurDto, MultipartFile pieceJointes);
    void delete(long id);
    Page<EmployeurDto> AllPagination(Pageable pageable);
}
