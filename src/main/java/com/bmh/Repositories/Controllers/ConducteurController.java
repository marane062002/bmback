package com.bmh.Repositories.Controllers;

import com.bmh.Models.Conducteur;
import com.bmh.beans.ConducteurDTO;
import com.bmh.services.impl.ConducteurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/conducteur")
public class ConducteurController {
	private final ConducteurServiceImpl service;

	@Autowired
	public ConducteurController(ConducteurServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ConducteurDTO>> getAllConducteur(){
		List<ConducteurDTO> consucteurdto=service.getAll();
		return new ResponseEntity<>(consucteurdto,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> CreateConducteur(@RequestBody ConducteurDTO conducteurDTO){
		service.create(conducteurDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ConducteurDTO> getById(@PathVariable Long id) {
		ConducteurDTO conducteurDTO = service.getById(id);
		return new ResponseEntity<>(conducteurDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateConducteur(@PathVariable Long id,@RequestBody ConducteurDTO conducteurDTO){
		ConducteurDTO conducteurDTO1=service.getById(id);
		if(!id.equals(conducteurDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,conducteurDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteConducteur(@PathVariable Long id){
		ConducteurDTO conducteurDTO1=service.getById(id);
		if(!id.equals(conducteurDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
