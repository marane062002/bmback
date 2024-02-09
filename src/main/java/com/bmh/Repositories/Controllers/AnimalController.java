package com.bmh.Repositories.Controllers;

import com.bmh.beans.AnimalDTO;
import com.bmh.services.impl.TypeTraitementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/animal")
public class AnimalController {
	private final TypeTraitementService.AnimalService service;

	public AnimalController(TypeTraitementService.AnimalService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<AnimalDTO>> getAll(){
		List<AnimalDTO> animalDTOS=service.getALl();
		return new ResponseEntity<>(animalDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDTO> getById(@PathVariable Long id){
		AnimalDTO animalDTO=service.getById(id);
		return new ResponseEntity<>(animalDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody AnimalDTO animalDTO){
		service.add(animalDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody AnimalDTO animalDTO){
		AnimalDTO animalDTO1=service.getById(id);
		if(!id.equals(animalDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,animalDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		AnimalDTO animalDTO=service.getById(id);
		if(!id.equals(animalDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
