package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.Models.medecinLegale.HistoriqueObstacel;
import com.bmh.beans.medecinLegale.HistoriqueObstacleDTO;
import com.bmh.services.medecinLegale.HistoriqueObstacleService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique-obstacle")
public class HistoriqueObstacleController {
    private final HistoriqueObstacleService service;
    private final ModelMapper mapper;

    public HistoriqueObstacleController(HistoriqueObstacleService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<HistoriqueObstacleDTO> Create(@RequestBody HistoriqueObstacleDTO historiqueObstacleDTO) {
        HistoriqueObstacel action = service.add(historiqueObstacleDTO);
        return new ResponseEntity<>(mapper.map(action, HistoriqueObstacleDTO.class), HttpStatus.OK);
    }

    @GetMapping("/{obstacleId}")
    public ResponseEntity<List<HistoriqueObstacel>> getHistoriqueByObstacleId(
            @PathVariable Long obstacleId) {
        return new ResponseEntity<>(service.findByObstacleDefuntsId(obstacleId), HttpStatus.OK);
    }
}
