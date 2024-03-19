package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Controleur;
import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import com.bmh.beans.PaginationDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.services.carteSanitaire.IEtablissementService;
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
@RequestMapping("/etablissements")
public class EtablissementController {

    private final IEtablissementService etablissementService;
    private final ModelMapper mapper;

    public EtablissementController(IEtablissementService etablissementService, ModelMapper mapper) {
        this.etablissementService = etablissementService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<EtablissementDTO>> getALl(){
        return new ResponseEntity<>(etablissementService.getALl(), HttpStatus.OK);
    }

    @GetMapping("/paginate/{pageNo}/{pageSize}")
    public ResponseEntity<Page<EtablissementDTO>> getAllwithPaginate(
            @PathVariable int pageNo,
            @PathVariable int pageSize,
            @RequestParam(required = false) NatureEtablissement nature,
            @RequestParam(required = false) EtatHygiene etatHygiene,
            @RequestParam(required = false) Arrondissement arrondissement,
            @RequestParam(required = false) Controleur controleur
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EtablissementDTO> page = etablissementService.getAllPaginationWithFilter(nature, etatHygiene, arrondissement, controleur, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }



//    @GetMapping("/paginate/{pageNo}/{pageSize}")
//    public ResponseEntity<Page<EtablissementDTO>> getAllwithPaginate(
//            @PathVariable int pageNo,
//            @PathVariable int pageSize,
//            @RequestParam(required = false) String nature
//    ) {
//        NatureEtablissement natureEnum = null;
//        if (nature != null) {
//            try {
//                natureEnum = NatureEtablissement.valueOf(nature); // Convert the string to enum
//            } catch (IllegalArgumentException e) {
//
//            }
//        }
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        Page<EtablissementDTO> page = etablissementService.getAllPaginationWithFilter(natureEnum.valueOf(), pageable);
//        return new ResponseEntity<>(page, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<EtablissementDTO> Create(@RequestBody EtablissementDTO etablissementDTO) {
        Etablissement etablissement = etablissementService.add(etablissementDTO);
        return new ResponseEntity<>(mapper.map(etablissement, EtablissementDTO.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody EtablissementDTO etablissementDTO
    ) {
        etablissementService.update(id, etablissementDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementDTO> getById(@PathVariable Long id) {
        EtablissementDTO etablissementDTO = etablissementService.getById(id);
        return new ResponseEntity<>(etablissementDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        etablissementService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
