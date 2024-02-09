package com.bmh.Repositories.Controllers;

import com.bmh.beans.QuantiteDTO;
import com.bmh.beans.QuartierDTO;
import com.bmh.services.impl.QuantiteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/quantite")
public class QuantiteController {
	private final QuantiteService service;

	public QuantiteController(QuantiteService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<QuantiteDTO>> getAll(){
		List<QuantiteDTO> quantiteDTOS=service.getALl();
		return new ResponseEntity<>(quantiteDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<QuantiteDTO> getById(@PathVariable Long id){
		QuantiteDTO quantiteDTO=service.getById(id);
		return new ResponseEntity<>(quantiteDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody QuantiteDTO quantiteDTO){
		service.add(quantiteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody QuantiteDTO quantiteDTO){
		QuantiteDTO quantiteDTO1=service.getById(id);
		if(!id.equals(quantiteDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,quantiteDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		QuantiteDTO quantiteDTO=service.getById(id);
		if(!id.equals(quantiteDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
