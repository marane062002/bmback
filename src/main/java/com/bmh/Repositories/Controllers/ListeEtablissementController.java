package com.bmh.Repositories.Controllers;

import com.bmh.beans.ConducteurDTO;
import com.bmh.beans.controle_sanitaire.ListEtablissementDTO;
import com.bmh.services.IListEtablissementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/listEtb")
public class ListeEtablissementController {
	private final IListEtablissementService service;

	public ListeEtablissementController(IListEtablissementService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ListEtablissementDTO>> getAl(){
		List<ListEtablissementDTO> listEtablissementDTOS=service.getAll();
		return new ResponseEntity<>(listEtablissementDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody ListEtablissementDTO listEtablissementDTO){
		service.add(listEtablissementDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ListEtablissementDTO> getById(@PathVariable Long id) {
		ListEtablissementDTO listEtablissementDTO = service.getById(id);
		return new ResponseEntity<>(listEtablissementDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateConducteur(@PathVariable Long id,@RequestBody ListEtablissementDTO listEtablissementDTO){
		ListEtablissementDTO listEtablissementDTO1=service.getById(id);
		if(!id.equals(listEtablissementDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,listEtablissementDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ListEtablissementDTO listEtablissementDTO1=service.getById(id);
		if(!id.equals(listEtablissementDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
