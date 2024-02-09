package com.bmh.Repositories.Controllers;

import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.ConventionDTO;
import com.bmh.services.IConventionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/convention")
public class ConventionController {
	private final IConventionService service;

	public ConventionController(IConventionService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ConventionDTO>> getAll(){
		List<ConventionDTO> conventionDTOS=service.getAll();
		return new ResponseEntity<>(conventionDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody ConventionDTO conventionDTO){
		service.add(conventionDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ConventionDTO> getById(@PathVariable Long id) {
		ConventionDTO conventionDTO = service.getById(id);
		return new ResponseEntity<>(conventionDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ConventionDTO conventionDTO){
		ConventionDTO conventionDTO1=service.getById(id);
		if(!id.equals(conventionDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,conventionDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ConventionDTO conventionDTO=service.getById(id);
		if(!id.equals(conventionDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
