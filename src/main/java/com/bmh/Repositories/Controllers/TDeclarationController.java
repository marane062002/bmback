package com.bmh.Repositories.Controllers;

import com.bmh.beans.TDeclarationDTO;
import com.bmh.beans.controle_sanitaire.DecisionDTO;
import com.bmh.services.ITDeclarationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/declaration")
public class TDeclarationController {
	private final ITDeclarationService service;

	public TDeclarationController(ITDeclarationService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TDeclarationDTO>> getAll(){
		List<TDeclarationDTO> tDeclarationDTOS=service.getALl();
		return new ResponseEntity<>(tDeclarationDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TDeclarationDTO> getById(@PathVariable Long id){
		TDeclarationDTO tDeclarationDTO=service.getById(id);
		return new ResponseEntity<>(tDeclarationDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody TDeclarationDTO tDeclarationDTO){
		service.add(tDeclarationDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TDeclarationDTO tDeclarationDTO){
		TDeclarationDTO tDeclarationDTO1=service.getById(id);
		if(!id.equals(tDeclarationDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,tDeclarationDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TDeclarationDTO tDeclarationDTO=service.getById(id);
		if(!id.equals(tDeclarationDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
