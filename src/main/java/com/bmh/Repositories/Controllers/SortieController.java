package com.bmh.Repositories.Controllers;

import com.bmh.Models.Sortie;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.beans.PaginationDto;
import com.bmh.beans.SortieDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.services.ISortieService;
import com.bmh.services.carteSanitaire.IEmployeService;
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
@RequestMapping("/sortie")
public class SortieController {
    private final ISortieService sortieService;
    private final ModelMapper mapper;

    public SortieController(ISortieService sortieService, ModelMapper mapper) {
        this.sortieService = sortieService;
        this.mapper = mapper;
    }


    @GetMapping("/paginate/{pageNo}/{pageSize}")
    public ResponseEntity<Page<SortieDTO>> getAllwithPaginate(
            @PathVariable int pageNo,
            @PathVariable int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SortieDTO> page = sortieService.AllPagination(pageable);
//        PaginationDto<SortieDTO> response = new PaginationDto<>(
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
    public ResponseEntity<List<SortieDTO>> getALl(){
        List<SortieDTO> sortieDTOS = sortieService.getALl();
        return new ResponseEntity<>(sortieService.getALl(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SortieDTO> Create(@RequestPart(name = "sortie") SortieDTO sortieDTO,
                                             @RequestPart(name = "procesVerbal") MultipartFile procesVerbal ,
                                             @RequestPart(name = "pieceJointe") MultipartFile pieceJointe) {
        Sortie sortie = sortieService.add(sortieDTO, procesVerbal, pieceJointe);
        SortieDTO responseDto = mapper.map(sortie, SortieDTO.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestPart(name = "sortie") SortieDTO sortieDTO,
                                       @RequestPart(name = "procesVerbal") MultipartFile procesVerbal ,
                                       @RequestPart(name = "pieceJointe") MultipartFile pieceJointe) {
        sortieService.update(id, sortieDTO, procesVerbal, pieceJointe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SortieDTO> getById(@PathVariable Long id) {
        SortieDTO sortieDTO = sortieService.getById(id);
        return new ResponseEntity<>(sortieDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        sortieService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
