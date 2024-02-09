package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.EnterrementObstacleDTO;
import com.bmh.services.impl.medecinLegale.EnterrementObstacleServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/entrObstacle")
public class EnterrementObstacleController {
	private final EnterrementObstacleServiceImpl service;

	public EnterrementObstacleController(EnterrementObstacleServiceImpl service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<EnterrementObstacleDTO>> getAll(){
		List<EnterrementObstacleDTO> enterrementObstacleDTOS=service.getALl();
		return new ResponseEntity<>(enterrementObstacleDTOS, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody EnterrementObstacleDTO enterrementObstacleDTO){
		service.add(enterrementObstacleDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<EnterrementObstacleDTO> getById(@PathVariable Long id) {
		EnterrementObstacleDTO enterrementObstacleDTO = service.getById(id);
		return new ResponseEntity<>(enterrementObstacleDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody EnterrementObstacleDTO enterrementObstacleDTO){
		EnterrementObstacleDTO enterrementObstacleDTO1=service.getById(id);
		if(!id.equals(enterrementObstacleDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,enterrementObstacleDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		EnterrementObstacleDTO enterrementObstacleDTO=service.getById(id);
		if(!id.equals(enterrementObstacleDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
