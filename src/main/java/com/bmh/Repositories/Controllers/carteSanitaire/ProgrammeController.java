package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Action;
import com.bmh.Models.controle_sanitaire.Programmes;
import com.bmh.beans.PaginationDto;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IProgrammeService;
import org.docx4j.wml.P;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/programme")
public class ProgrammeController {
    private final IProgrammeService programmeService;

    private final ModelMapper mapper;

    public ProgrammeController(IProgrammeService programmeService, ModelMapper mapper) {
        this.programmeService = programmeService;
        this.mapper = mapper;
    }

    @GetMapping("/paginate/{pageNo}/{pageSize}")
    public ResponseEntity<Page<ProgrammeDto>> getAllwithPaginate(
            @PathVariable int pageNo,
            @PathVariable int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ProgrammeDto> page = programmeService.AllPagination(pageable);

//        PaginationDto<ProgrammeDto> response = new PaginationDto<>(
//                page.getContent(),
//                page.getNumber(),
//                page.getSize(),
//                page.getTotalElements(),
//                page.getTotalPages(),
//                page.isLast()
//        );
        return new ResponseEntity<>(page, HttpStatus.OK);
    };
    @GetMapping
    public ResponseEntity<List<ProgrammeDto>> getALl(){
        List<ProgrammeDto> programmeDtos=programmeService.getALl();
        return new ResponseEntity<>(programmeService.getALl(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgrammeDto> Create(@RequestBody ProgrammeDto programmeDto) {
        Programmes programmes = programmeService.add(programmeDto);
        return new ResponseEntity<>(mapper.map(programmes, ProgrammeDto.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody ProgrammeDto programmeDto
    ) {
        programmeService.update(id, programmeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammeDto> getById(@PathVariable Long id) {
        ProgrammeDto programmeDto = programmeService.getById(id);
        return new ResponseEntity<>(programmeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        programmeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
