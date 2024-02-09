package com.bmh.Repositories.Controllers;

import com.bmh.beans.CommuneDTO;
import com.bmh.services.impl.CommuneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/commune")
public class CommuneController {
	private final CommuneService service;

	public CommuneController(CommuneService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<CommuneDTO>> getAll(){
		List<CommuneDTO> communeDTOS=service.getALl();
		return new ResponseEntity<>(communeDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CommuneDTO> getById(@PathVariable Long id){
		CommuneDTO communeDTO=service.getById(id);
		return new ResponseEntity<>(communeDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CommuneDTO communeDTO){
		service.add(communeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody CommuneDTO communeDTO){
		CommuneDTO communeDTO1=service.getById(id);
		if(!id.equals(communeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,communeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		CommuneDTO communeDTO=service.getById(id);
		if(!id.equals(communeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
