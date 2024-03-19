package com.bmh.Repositories.Controllers.Vaccination;

import com.bmh.Models.vaccination.TypeAnimal;
import com.bmh.beans.VaccinationDTO.TypeAnimalDto;
import com.bmh.services.Vaccination.ITypeAnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/type-animal")
public class TypeAnimalController {

    private final ITypeAnimalService typeAnimalService;

    private final ModelMapper mapper;

    public TypeAnimalController(ITypeAnimalService typeAnimalService, ModelMapper mapper) {
        this.typeAnimalService = typeAnimalService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<TypeAnimalDto>> getALl(){
        List<TypeAnimalDto> typeAnimalDtos=typeAnimalService.getALl();
        return new ResponseEntity<>(typeAnimalService.getALl(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeAnimalDto> Create(@RequestBody TypeAnimalDto typeAnimalDto) {
        TypeAnimal typeAnimal = typeAnimalService.add(typeAnimalDto);
        return new ResponseEntity<>(mapper.map(typeAnimal, TypeAnimalDto.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeAnimalDto> update(@PathVariable Long id,
                                       @RequestBody TypeAnimalDto typeAnimalDto
    ) {
        TypeAnimal typeAnimal = typeAnimalService.update(id, typeAnimalDto);
        return new ResponseEntity<>(mapper.map(typeAnimal, TypeAnimalDto.class), HttpStatus.OK);
//        return new ResponseEntity<>(infosGenerales,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeAnimalDto> getById(@PathVariable Long id) {
        TypeAnimalDto typeAnimalDto = typeAnimalService.getById(id);
        return new ResponseEntity<>(typeAnimalDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        typeAnimalService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
