package com.bmh.Repositories.Controllers;

import com.bmh.beans.TVacationDTO;
import com.bmh.beans.controle_sanitaire.DecisionDTO;
import com.bmh.services.impl.TypeVacationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/tvacation")
public class TVacationController {
	private final TypeVacationService service;

	public TVacationController(TypeVacationService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TVacationDTO>> getAll(){
		List<TVacationDTO> tVacationDTOS=service.getALl();
		return new ResponseEntity<>(tVacationDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TVacationDTO> getById(@PathVariable Long id){
		TVacationDTO tVacationDTO=service.getById(id);
		return new ResponseEntity<>(tVacationDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody TVacationDTO tVacationDTO){
		service.add(tVacationDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TVacationDTO tVacationDTO){
		TVacationDTO tVacationDTO1=service.getById(id);
		if(!id.equals(tVacationDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,tVacationDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TVacationDTO tVacationDTO=service.getById(id);
		if(!id.equals(tVacationDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
