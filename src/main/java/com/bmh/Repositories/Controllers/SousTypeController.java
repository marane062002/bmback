package com.bmh.Repositories.Controllers;

import com.bmh.beans.controle_sanitaire.SousTypeDTO;
import com.bmh.services.ISousTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/soustype")
public class SousTypeController {
	private final ISousTypeService service;

	public SousTypeController(ISousTypeService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<SousTypeDTO>> getAll(){
		List<SousTypeDTO> sousTypeDTOS=service.getAll();
		return new ResponseEntity<>(sousTypeDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<SousTypeDTO> getById(@PathVariable Long id){
		SousTypeDTO sousTypeDTO=service.getById(id);
		return new ResponseEntity<>(sousTypeDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody SousTypeDTO sousTypeDTO){
		service.add(sousTypeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public  ResponseEntity<Void> update(@PathVariable Long id,@RequestBody SousTypeDTO sousTypeDTO){
		SousTypeDTO sousTypeDTO1=service.getById(id);
		if(!id.equals(sousTypeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,sousTypeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		SousTypeDTO sousTypeDTO1=service.getById(id);
		if(!id.equals(sousTypeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
