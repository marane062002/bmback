package com.bmh.Repositories.Controllers.carteSanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.Action;
import com.bmh.Models.controle_sanitaire.PersonnesEtab.Physique;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.PhysiqueDto;
import com.bmh.services.carteSanitaire.PersonnesEtab.IPhysiqueService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/physique")
public class PhysiqueController {
    private final IPhysiqueService physiqueService;
    private final ModelMapper mapper;

    public PhysiqueController(IPhysiqueService physiqueService, ModelMapper mapper) {
        this.physiqueService = physiqueService;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<List<PhysiqueDto>> getALl(){
        return new ResponseEntity<>(physiqueService.getALl(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhysiqueDto> Create(@RequestBody PhysiqueDto physiqueDto) {
        Physique physique = physiqueService.add(physiqueDto);
        return new ResponseEntity<>(mapper.map(physique, PhysiqueDto.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody PhysiqueDto physiqueDto
    ) {
        physiqueService.update(id, physiqueDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhysiqueDto> getById(@PathVariable Long id) {
        PhysiqueDto physiqueDto = physiqueService.getById(id);
        return new ResponseEntity<>(physiqueDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        physiqueService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
