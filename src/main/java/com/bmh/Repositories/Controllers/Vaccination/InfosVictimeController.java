package com.bmh.Repositories.Controllers.Vaccination;

import com.bmh.Models.vaccination.InfosVictime;
import com.bmh.beans.VaccinationDTO.InfosVictimeDto;
import com.bmh.services.Vaccination.IinfosVictimeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/infos-victimes")
public class InfosVictimeController {
    private final IinfosVictimeService victimeService;
    private final ModelMapper mapper;

    public InfosVictimeController(IinfosVictimeService victimeService, ModelMapper mapper) {
        this.victimeService = victimeService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<InfosVictimeDto>> getAll(){
        List<InfosVictimeDto> infosVictimeDtos=victimeService.getALl();
        return new ResponseEntity<>(infosVictimeDtos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<InfosVictimeDto> create(
            @RequestBody InfosVictimeDto infosVictimeDto) {
        InfosVictime infosVictime = victimeService.add(infosVictimeDto);
        return new ResponseEntity<>(mapper.map(infosVictime, InfosVictimeDto.class), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<InfosVictimeDto> getById(@PathVariable Long id) {
        InfosVictimeDto infosVictimeDto = victimeService.getById(id);
        return new ResponseEntity<>(infosVictimeDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody InfosVictimeDto infosVictimeDto ){
        victimeService.update(id, infosVictimeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        victimeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
