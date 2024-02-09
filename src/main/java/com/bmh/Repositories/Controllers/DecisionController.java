package com.bmh.Repositories.Controllers;

import com.bmh.beans.ConducteurDTO;
import com.bmh.beans.controle_sanitaire.DecisionDTO;
import com.bmh.services.IDecisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/decision")
public class DecisionController {
	private final IDecisionService service;

	public DecisionController(IDecisionService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<DecisionDTO>> getAll(){
		List<DecisionDTO> decisionDTOS=service.getAll();
		return new ResponseEntity<>(decisionDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<DecisionDTO> getById(@PathVariable Long id){
		DecisionDTO decisionDTO=service.getById(id);
		return new ResponseEntity<>(decisionDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody DecisionDTO decisionDTO){
		service.add(decisionDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody DecisionDTO decisionDTO){
		DecisionDTO decisionDTO1=service.getById(id);
		if(!id.equals(decisionDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,decisionDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		DecisionDTO decisionDTO1=service.getById(id);
		if(!id.equals(decisionDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
