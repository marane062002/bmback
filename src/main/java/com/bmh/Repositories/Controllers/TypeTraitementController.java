package com.bmh.Repositories.Controllers;

import com.bmh.beans.TypeTraitementDTO;
import com.bmh.services.impl.TypeTraitementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/type-traitement")
public class TypeTraitementController {
	private final TypeTraitementService service;

	public TypeTraitementController(TypeTraitementService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TypeTraitementDTO>> getAll(){
		List<TypeTraitementDTO> typeTraitementDTOS=service.getALl();
		return new ResponseEntity<>(typeTraitementDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TypeTraitementDTO> getById(@PathVariable Long id){
		TypeTraitementDTO typeTraitementDTO=service.getById(id);
		return new ResponseEntity<>(typeTraitementDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody TypeTraitementDTO typeTraitementDTO){
		service.add(typeTraitementDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TypeTraitementDTO typeTraitementDTO){
		TypeTraitementDTO typeTraitementDTO1=service.getById(id);
		if(!id.equals(typeTraitementDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,typeTraitementDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TypeTraitementDTO typeTraitementDTO=service.getById(id);
		if(!id.equals(typeTraitementDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
