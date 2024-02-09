package com.bmh.Repositories.Controllers;

import com.bmh.beans.QuantiteDTO;
import com.bmh.beans.QuartierDTO;
import com.bmh.services.impl.QuartierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/quartier")
public class QuartierController {
	private final QuartierService service;

	public QuartierController(QuartierService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<QuartierDTO>> getAll(){
		List<QuartierDTO> quartierDTOS=service.getALl();
		return new ResponseEntity<>(quartierDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<QuartierDTO> getById(@PathVariable Long id){
		QuartierDTO quartierDTO=service.getById(id);
		return new ResponseEntity<>(quartierDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody QuartierDTO quartierDTO){
		service.add(quartierDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody QuartierDTO quartierDTO){
		QuartierDTO quartierDTO1=service.getById(id);
		if(!id.equals(quartierDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,quartierDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		QuartierDTO quartierDTO=service.getById(id);
		if(!id.equals(quartierDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
