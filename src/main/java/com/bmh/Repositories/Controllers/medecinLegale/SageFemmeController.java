package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.SageFemmeDTO;
import com.bmh.services.impl.medecinLegale.SageFemmeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/sage")
public class SageFemmeController {
	private final SageFemmeServiceImpl service;

	public SageFemmeController(SageFemmeServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<SageFemmeDTO>> getAll(){
		List<SageFemmeDTO> sageFemmeDTOS=service.getALl();
		return new ResponseEntity<>(sageFemmeDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<SageFemmeDTO> getById(@PathVariable Long id){
		SageFemmeDTO sageFemmeDTO=service.getById(id);
		return new ResponseEntity<>(sageFemmeDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody SageFemmeDTO sageFemmeDTO){
		service.add(sageFemmeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody SageFemmeDTO sageFemmeDTO){
		SageFemmeDTO sageFemmeDTO1=service.getById(id);
		if(!id.equals(sageFemmeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,sageFemmeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		SageFemmeDTO sageFemmeDTO=service.getById(id);
		if(!id.equals(sageFemmeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
