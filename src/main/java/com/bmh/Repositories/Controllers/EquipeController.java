package com.bmh.Repositories.Controllers;

import com.bmh.beans.EquipeDTO;
import com.bmh.services.impl.EquipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/equipe")
public class EquipeController {
	private final EquipeService service;

	public EquipeController(EquipeService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<EquipeDTO>> getAll(){
		List<EquipeDTO> equipeDTOS=service.getALl();
		return new ResponseEntity<>(equipeDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<EquipeDTO> getById(@PathVariable Long id){
		EquipeDTO equipeDTO=service.getById(id);
		return new ResponseEntity<>(equipeDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody EquipeDTO equipeDTO){
		service.add(equipeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody EquipeDTO equipeDTO){
		EquipeDTO equipeDTO1=service.getById(id);
		if(!id.equals(equipeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,equipeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		EquipeDTO equipeDTO=service.getById(id);
		if(!id.equals(equipeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
