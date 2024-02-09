package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.medecinLegale.InformationsDeclarantsDTO;
import com.bmh.services.impl.medecinLegale.InformationsDeclarantsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/infoDclrt")
public class InformationsDeclarantsController {
	private final InformationsDeclarantsServiceImpl service;

	public InformationsDeclarantsController(InformationsDeclarantsServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<InformationsDeclarantsDTO>> getAll(){
		List<InformationsDeclarantsDTO> informationsDeclarantsDTOS=service.getALl();
		return new ResponseEntity<>(informationsDeclarantsDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody InformationsDeclarantsDTO informationsDeclarantsDTO){
		service.add(informationsDeclarantsDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<InformationsDeclarantsDTO> getById(@PathVariable Long id) {
		InformationsDeclarantsDTO informationsDeclarantsDTO = service.getById(id);
		return new ResponseEntity<>(informationsDeclarantsDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody InformationsDeclarantsDTO informationsDeclarantsDTO){
		InformationsDeclarantsDTO informationsDeclarantsDTO1=service.getById(id);
		if(!id.equals(informationsDeclarantsDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,informationsDeclarantsDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		InformationsDeclarantsDTO informationsDeclarantsDTO=service.getById(id);
		if(!id.equals(informationsDeclarantsDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
