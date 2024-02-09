package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.SageFemmeDTO;
import com.bmh.beans.medecinLegale.TransfertDTO;
import com.bmh.services.medecinLegale.TransfertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/transfert")
public class TransfertController {
	private final TransfertService service;

	public TransfertController(TransfertService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TransfertDTO>> getAll(){
		List<TransfertDTO> transfertDTOS=service.getALl();
		return new ResponseEntity<>(transfertDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TransfertDTO> getById(@PathVariable Long id){
		TransfertDTO transfertDTO=service.getById(id);
		return new ResponseEntity<>(transfertDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody TransfertDTO transfertDTO){
		service.add(transfertDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TransfertDTO transfertDTO){
		TransfertDTO transfertDTO1=service.getById(id);
		if(!id.equals(transfertDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,transfertDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TransfertDTO transfertDTO=service.getById(id);
		if(!id.equals(transfertDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
