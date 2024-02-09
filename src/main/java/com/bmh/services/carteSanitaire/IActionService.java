package com.bmh.services.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Action;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IActionService {
    Action add(ActionDto actionDto);
    List<ActionDto> getALl();
    ActionDto getById(long id);
    void update(long id,ActionDto actionDto);
    void delete(long id);
    Page<ActionDto> AllPagination(Pageable pageable);
}
