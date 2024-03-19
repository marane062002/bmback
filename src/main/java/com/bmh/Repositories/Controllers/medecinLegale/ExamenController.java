package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.ExamenDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.services.impl.medecinLegale.ExamenServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/examenn")
public class ExamenController {
	private final ExamenServiceImpl service;

	public ExamenController(ExamenServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/statistics-examens")
	public List<Map<String, Object>> getExamenStatistics() {
		return service.getExamenStatistics();
	}

	@GetMapping
	public ResponseEntity<List<ExamenDTO>> getAll(){
		List<ExamenDTO> examenDTOS=service.getALl();
		return new ResponseEntity<>(examenDTOS, HttpStatus.OK);
	}
	@GetMapping("/obstacle/{id}")
	public ResponseEntity<List<ExamenDTO>> getByIdObstacle(@PathVariable Long id){
		List<ExamenDTO> examenDTOS=service.getByIdObstacle(id);
		return new ResponseEntity<>(examenDTOS,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ExamenDTO> getById(@PathVariable Long id){
		ExamenDTO examenDTO=service.getById(id);
		return new ResponseEntity<>(examenDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ExamenDTO examenDTO){
		service.add(examenDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ExamenDTO examenDTO){
		ExamenDTO examenDTO1=service.getById(id);
		if(!id.equals(examenDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,examenDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ExamenDTO examenDTO=service.getById(id);
		if(!id.equals(examenDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
