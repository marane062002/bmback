package com.bmh.Repositories.Controllers;

import com.bmh.Models.MedecinOperant;
import com.bmh.beans.MedecinOperantDTO;
import com.bmh.services.impl.MedecinOperantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/medecin")
public class MedecinOperantController {

	private final MedecinOperantImpl service;

	@Autowired
	public MedecinOperantController(MedecinOperantImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<MedecinOperantDTO>> getAllMedecin(){
		List<MedecinOperantDTO> medecinOperantDTOS=service.getAll();
		return new ResponseEntity<>(medecinOperantDTOS,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> CreateMedecin(@RequestBody MedecinOperantDTO medecinOperantDTO){
		service.add(medecinOperantDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<MedecinOperantDTO> getMedecinById(@PathVariable Long id){
		MedecinOperantDTO medecinOperantDTO1=service.getById(id);
		return new ResponseEntity<>(medecinOperantDTO1,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public  ResponseEntity<MedecinOperantDTO> updateMedecin(@PathVariable Long id,@RequestBody MedecinOperantDTO medecinOperantDTO){
		if(!id.equals(medecinOperantDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,medecinOperantDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMedecin(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
