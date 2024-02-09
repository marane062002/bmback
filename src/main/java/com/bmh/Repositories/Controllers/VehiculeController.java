package com.bmh.Repositories.Controllers;

import com.bmh.Models.Vehicule;
import com.bmh.beans.VehiculeDTO;
import com.bmh.services.IVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/vehicule")
public class VehiculeController {
	private final IVehiculeService service;

	@Autowired
	public VehiculeController(IVehiculeService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<VehiculeDTO>> getAll(){
		List<VehiculeDTO> vehiculeDTOS=service.getAll();
		return new ResponseEntity<>(vehiculeDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public 	ResponseEntity<VehiculeDTO> getById(@PathVariable long id){
		VehiculeDTO viheculeDto=service.getById(id);
		return new ResponseEntity<>(viheculeDto,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody VehiculeDTO vehiculeDTO){
		service.create(vehiculeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody VehiculeDTO vehiculeDTO){
		VehiculeDTO vehicule=service.getById(id);
		if(!id.equals(vehicule.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,vehiculeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		VehiculeDTO vehiculeDTO=service.getById(id);
		if(!id.equals(vehiculeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
