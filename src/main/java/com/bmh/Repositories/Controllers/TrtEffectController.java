package com.bmh.Repositories.Controllers;

import com.bmh.beans.TraitEffectDTO;
import com.bmh.services.ITraitEffectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/traitement")
public class TrtEffectController {
	private final ITraitEffectService service;

	public TrtEffectController(ITraitEffectService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TraitEffectDTO>> getAll(){
		List<TraitEffectDTO> traitEffectDTOS=service.getALl();
		return new ResponseEntity<>(traitEffectDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TraitEffectDTO> getById(@PathVariable Long id){
		TraitEffectDTO traitEffectDTO=service.getById(id);
		return new ResponseEntity<>(traitEffectDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody TraitEffectDTO traitEffectDTO){
		service.add(traitEffectDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TraitEffectDTO traitEffectDTO){
		TraitEffectDTO traitEffectDTO1=service.getById(id);
		if(!id.equals(traitEffectDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,traitEffectDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TraitEffectDTO traitEffectDTO1=service.getById(id);
		if(!id.equals(traitEffectDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
