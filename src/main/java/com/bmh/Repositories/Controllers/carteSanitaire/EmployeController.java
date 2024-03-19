package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.services.carteSanitaire.IEmployeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/employe")
public class EmployeController {
    private final IEmployeService employeService;
    private final ModelMapper mapper;

    public EmployeController(IEmployeService employeService, ModelMapper mapper) {
        this.employeService = employeService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<EmployeDto>> getALl(){
        return new ResponseEntity<>(employeService.getALl(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeDto> Create(@RequestPart(name = "employe") EmployeDto employeDto) {
        Employe employe = employeService.add(employeDto);
        EmployeDto responseDto = mapper.map(employe, EmployeDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestPart(name = "employe") EmployeDto employeDto) {
        employeService.update(id, employeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeDto> getById(@PathVariable Long id) {
        EmployeDto employeDto = employeService.getById(id);
        return new ResponseEntity<>(employeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
