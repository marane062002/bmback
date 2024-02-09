package com.bmh.Repositories.Controllers;

import com.bmh.Models.controle_sanitaire.TypeControleSanitaire;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.beans.controle_sanitaire.TypeControleDTO;
import com.bmh.services.impl.TypeControleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/typectrl")
public class TypeCtrlController {
	private final TypeControleServiceImpl service;

	public TypeCtrlController(TypeControleServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TypeControleDTO>> getAllTypeControle(){
		List<TypeControleDTO> typeControleDTOS=service.getAll();
		return new ResponseEntity<>(typeControleDTOS,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TypeControleDTO> getById(@PathVariable Long id){
		TypeControleDTO typeControleDTO=service.getById(id);
		return new ResponseEntity<>(typeControleDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody TypeControleDTO typeControleDTO){
		service.add(typeControleDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TypeControleDTO typeControleDTO){
		TypeControleDTO typeControleSanitaire=service.getById(id);
		if(!id.equals(typeControleSanitaire.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,typeControleDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TypeControleDTO typeControleDTO=service.getById(id);
		if(!id.equals(typeControleDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
