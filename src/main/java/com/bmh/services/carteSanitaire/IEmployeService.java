package com.bmh.services.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEmployeService {
    Employe add(EmployeDto employeDto);
    List<EmployeDto> getALl();
    EmployeDto getById(long id);

    void update(long id,EmployeDto employeDto);
    void delete(long id);
}
