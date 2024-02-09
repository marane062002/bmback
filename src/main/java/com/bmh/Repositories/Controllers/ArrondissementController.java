package com.bmh.Repositories.Controllers;

import com.bmh.beans.ArrondissementDTO;
import com.bmh.services.impl.ArrondissementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/arrondissement")
public class ArrondissementController {
	private final ArrondissementService service;

	public ArrondissementController(ArrondissementService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ArrondissementDTO>> getAll(){
		List<ArrondissementDTO> arrondissementDTOS=service.getALl();
		return new ResponseEntity<>(arrondissementDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ArrondissementDTO> getById(@PathVariable Long id){
		ArrondissementDTO arrondissementDTO=service.getById(id);
		return new ResponseEntity<>(arrondissementDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ArrondissementDTO arrondissementDTO){
		service.add(arrondissementDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ArrondissementDTO arrondissementDTO){
		ArrondissementDTO arrondissementDTO1=service.getById(id);
		if(!id.equals(arrondissementDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,arrondissementDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ArrondissementDTO arrondissementDTO=service.getById(id);
		if(!id.equals(arrondissementDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
