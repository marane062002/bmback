package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Action;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.beans.PaginationDto;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.services.carteSanitaire.IActionService;
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
@RequestMapping("/actions-dec")
public class ActionController {
    private final IActionService actionService;
    private final ModelMapper mapper;

    public ActionController(IActionService actionService, ModelMapper mapper) {
        this.actionService = actionService;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<List<ActionDto>> getALl(){
        return new ResponseEntity<>(actionService.getALl(), HttpStatus.OK);
    }

    @GetMapping("/paginate/{pageNo}/{pageSize}")
    public ResponseEntity<Page<ActionDto>> getAllwithPaginate(
            @PathVariable int pageNo,
            @PathVariable int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<ActionDto> page = actionService.AllPagination(pageable);

//        PaginationDto<ActionDto> response = new PaginationDto<>(
//                page.getContent(),
//                page.getNumber(),
//                page.getSize(),
//                page.getTotalElements(),
//                page.getTotalPages(),
//                page.isLast()
//        );

        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ActionDto> Create(@RequestBody ActionDto actionDto) {
        Action action = actionService.add(actionDto);
        return new ResponseEntity<>(mapper.map(action, ActionDto.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody ActionDto actionDto
                                       ) {
        actionService.update(id, actionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionDto> getById(@PathVariable Long id) {
        ActionDto actionDto = actionService.getById(id);
        return new ResponseEntity<>(actionDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        actionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
