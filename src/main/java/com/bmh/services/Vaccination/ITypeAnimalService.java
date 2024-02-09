package com.bmh.services.Vaccination;

import com.bmh.Models.vaccination.TypeAnimal;
import com.bmh.beans.VaccinationDTO.TypeAnimalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeAnimalService {
    TypeAnimal add(TypeAnimalDto typeAnimalDto);
    List<TypeAnimalDto> getALl();
    TypeAnimalDto getById(long id);
    void update(long id,TypeAnimalDto typeAnimalDto);
    void delete(long id);
}
