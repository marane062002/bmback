package com.bmh.Repositories.Controllers;

import com.bmh.beans.ProduitUtiliseDTO;
import com.bmh.services.impl.ProduitUtiliseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/produit")
public class ProduitUtiliseController {
	private final ProduitUtiliseService service;

	public ProduitUtiliseController(ProduitUtiliseService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ProduitUtiliseDTO>> getAll(){
		List<ProduitUtiliseDTO> produitUtiliseDTOS=service.getALl();
		return new ResponseEntity<>(produitUtiliseDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProduitUtiliseDTO> getById(@PathVariable Long id){
		ProduitUtiliseDTO produitUtiliseDTO=service.getById(id);
		return new ResponseEntity<>(produitUtiliseDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ProduitUtiliseDTO produitUtiliseDTO){
		service.add(produitUtiliseDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ProduitUtiliseDTO produitUtiliseDTO){
		ProduitUtiliseDTO produitUtiliseDTO1=service.getById(id);
		if(!id.equals(produitUtiliseDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,produitUtiliseDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ProduitUtiliseDTO produitUtiliseDTO=service.getById(id);
		if(!id.equals(produitUtiliseDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
