package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.beans.medecinLegale.HistoriqueDecesDTO;
import com.bmh.services.medecinLegale.HistoriqueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique-deces")
public class HistoriqueDecesController {
    private final HistoriqueService service;
    private final ModelMapper mapper;

    public HistoriqueDecesController(HistoriqueService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity<HistoriqueDecesDTO> Create(@RequestBody HistoriqueDecesDTO historiqueDecesDTO) {
        HistoriqueDeces action = service.add(historiqueDecesDTO);
        return new ResponseEntity<>(mapper.map(action, HistoriqueDecesDTO.class), HttpStatus.OK);
    }
    @GetMapping("/{decesNaturelId}")
    public ResponseEntity<List<HistoriqueDeces>> getHistoriqueByDecesId(
            @PathVariable Long decesNaturelId) {
        return new ResponseEntity<>(service.findByDecesNaturelId(decesNaturelId), HttpStatus.OK);
    }

}
