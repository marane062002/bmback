package com.bmh.Repositories.Controllers;

import com.bmh.beans.AnimalDTO;
import com.bmh.beans.StatusDTO;
import com.bmh.services.impl.StatusServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/status")
public class StatutController {
	private final StatusServiceImpl service;

	public StatutController(StatusServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<StatusDTO>> getAll(){
		List<StatusDTO> statusDTOS=service.getAll();
		return new ResponseEntity<>(statusDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<StatusDTO> getById(@PathVariable Long id){
		StatusDTO statusDTO=service.getById(id);
		return new ResponseEntity<>(statusDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody StatusDTO statusDTO){
		service.create(statusDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody StatusDTO statusDTO){
		StatusDTO statusDTO1=service.getById(id);
		if(!id.equals(statusDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,statusDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		StatusDTO statusDTO=service.getById(id);
		if(!id.equals(statusDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
