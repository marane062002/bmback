package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.beans.PaginationDto;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.services.carteSanitaire.IEmployeur;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/employeur")
public class EmployeurController {
    private final IEmployeur iEmployeur;
    private final ModelMapper mapper;

    public EmployeurController(IEmployeur iEmployeur, ModelMapper mapper) {
        this.iEmployeur = iEmployeur;
        this.mapper = mapper;
    }
    @GetMapping("/paginate/{pageNo}/{pageSize}")
    public ResponseEntity<Page<EmployeurDto>> getAllwithPaginate(
            @PathVariable int pageNo,
            @PathVariable int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<EmployeurDto> page = iEmployeur.AllPagination(pageable);

//        PaginationDto<EmployeurDto> response = new PaginationDto<>(
//                page.getContent(),
//                page.getNumber(),
//                page.getSize(),
//                page.getTotalElements(),
//                page.getTotalPages(),
//                page.isLast()
//        );

        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeurDto>> getAll(){
        List<EmployeurDto> employeurDtos=iEmployeur.getALl();
        return new ResponseEntity<>(employeurDtos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeurDto> create(
            @RequestPart(name = "employeur") EmployeurDto employeurDto,
            @RequestPart(name = "pieceJointes") MultipartFile pieceJointes) {
        Employeur employeur = iEmployeur.add(employeurDto, pieceJointes);
        return new ResponseEntity<>(mapper.map(employeur, EmployeurDto.class), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeurDto> getById(@PathVariable Long id) {
        EmployeurDto employeurDto = iEmployeur.getById(id);
        return new ResponseEntity<>(employeurDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestPart(name = "employeur") EmployeurDto employeurDto,
                                       @RequestPart(name = "pieceJointes") MultipartFile pieceJointes ){
        iEmployeur.update(id, employeurDto, pieceJointes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iEmployeur.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
