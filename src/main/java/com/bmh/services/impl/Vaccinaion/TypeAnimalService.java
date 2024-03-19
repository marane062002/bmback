package com.bmh.services.impl.Vaccinaion;

import com.bmh.Models.vaccination.InfosVictime;
import com.bmh.Models.vaccination.TypeAnimal;
import com.bmh.Repositories.Vaccination.InfosVictimeRepository;
import com.bmh.Repositories.Vaccination.TypeAnimalRepository;
import com.bmh.beans.VaccinationDTO.InfosVictimeDto;
import com.bmh.beans.VaccinationDTO.TypeAnimalDto;
import com.bmh.services.Mapper;
import com.bmh.services.Vaccination.ITypeAnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAnimalService implements ITypeAnimalService {

    private final TypeAnimalRepository typeAnimalRepository;
    private final Mapper mapper;

    public TypeAnimalService(TypeAnimalRepository typeAnimalRepository, Mapper mapper) {
        this.typeAnimalRepository = typeAnimalRepository;
        this.mapper = mapper;
    }

    @Override
    public TypeAnimal add(TypeAnimalDto typeAnimalDto) {
        return mapper.map(typeAnimalRepository.save(mapper.map(typeAnimalDto, TypeAnimal.class)),TypeAnimal.class);
    }

    @Override
    public List<TypeAnimalDto> getALl() {
        return mapper.mapList(typeAnimalRepository.findAll(), TypeAnimalDto.class);
    }

    @Override
    public TypeAnimalDto getById(long id) {
        TypeAnimal typeAnimal=typeAnimalRepository.findById(id).get();
        return mapper.map(typeAnimal,TypeAnimalDto.class);
    }

    @Override
    public TypeAnimal update(long id, TypeAnimalDto typeAnimalDto) {
        if(!typeAnimalRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        typeAnimalDto.setId(id);
       return mapper.map(typeAnimalRepository.save(mapper.map(typeAnimalDto, TypeAnimal.class)), TypeAnimal.class);
    }

    @Override
    public void delete(long id) {
        if(!typeAnimalRepository.existsById(id)) {
            throw new RuntimeException("établissement n'éxiste pas");
        }
        try {
            typeAnimalRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }
}
