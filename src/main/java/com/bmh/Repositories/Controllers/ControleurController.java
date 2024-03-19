package com.bmh.Repositories.Controllers;

import com.bmh.beans.ConducteurDTO;
import com.bmh.beans.ControleurDTO;
import com.bmh.services.impl.ControleurServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controleur")
public class ControleurController {
    private final ControleurServiceImpl service;

    public ControleurController(ControleurServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ControleurDTO>> getAllControleur(){
        List<ControleurDTO> controleurDTOS=service.getAll();
        return new ResponseEntity<>(controleurDTOS, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> Create(@RequestBody ControleurDTO controleurDTO){
        service.create(controleurDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ControleurDTO> getById(@PathVariable Long id) {
        ControleurDTO controleurDTO = service.getById(id);
        return new ResponseEntity<>(controleurDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ControleurDTO controleurDTO){
        ControleurDTO controleurDTO1=service.getById(id);
        if(!id.equals(controleurDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,controleurDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ControleurDTO controleurDTO=service.getById(id);
        if(!id.equals(controleurDTO.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
