package com.bmh.Repositories.Controllers.carteSanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.Action;
import com.bmh.Models.controle_sanitaire.PersonnesEtab.Morale;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.MoraleDto;
import com.bmh.services.carteSanitaire.PersonnesEtab.IMoraleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/morale")
public class MoraleController {
    private final IMoraleService moraleService;
    private final ModelMapper mapper;

    public MoraleController(IMoraleService moraleService, ModelMapper mapper) {
        this.moraleService = moraleService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<MoraleDto>> getALl(){
        return new ResponseEntity<>(moraleService.getALl(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MoraleDto> Create(@RequestBody MoraleDto moraleDto) {
        Morale morale = moraleService.add(moraleDto);
        return new ResponseEntity<>(mapper.map(morale, MoraleDto.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody MoraleDto moraleDto
    ) {
        moraleService.update(id, moraleDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoraleDto> getById(@PathVariable Long id) {
        MoraleDto moraleDto = moraleService.getById(id);
        return new ResponseEntity<>(moraleDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        moraleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
