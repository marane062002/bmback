package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.ActeMariageDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.services.impl.medecinLegale.ActeMariageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/acte")
public class ActeMariageController {
	private final ActeMariageServiceImpl service;

	public ActeMariageController(ActeMariageServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ActeMariageDTO>> getAll(){
		List<ActeMariageDTO> acteMariageDTOS=service.getALl();
		return new ResponseEntity<>(acteMariageDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ActeMariageDTO> getById(@PathVariable Long id){
		ActeMariageDTO acteMariageDTO=service.getById(id);
		return new ResponseEntity<>(acteMariageDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ActeMariageDTO acteMariageDTO){
		service.add(acteMariageDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ActeMariageDTO acteMariageDTO){
		ActeMariageDTO acteMariageDTO1=service.getById(id);
		if(!id.equals(acteMariageDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,acteMariageDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ActeMariageDTO acteMariageDTO=service.getById(id);
		if(!id.equals(acteMariageDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
