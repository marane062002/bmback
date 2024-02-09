package com.bmh.Repositories.Controllers;

import com.bmh.beans.ObjetSortieDTO;
import com.bmh.services.impl.ObjetSortieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/objet")
public class ObjetSortieController {
	private final ObjetSortieService service;

	public ObjetSortieController(ObjetSortieService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ObjetSortieDTO>> getAll(){
		List<ObjetSortieDTO> objetSortieDTOS=service.getALl();
		return new ResponseEntity<>(objetSortieDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ObjetSortieDTO> getById(@PathVariable Long id){
		ObjetSortieDTO objetSortieDTO=service.getById(id);
		return new ResponseEntity<>(objetSortieDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ObjetSortieDTO objetSortieDTO){
		service.add(objetSortieDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ObjetSortieDTO objetSortieDTO){
		ObjetSortieDTO objetSortieDTO1=service.getById(id);
		if(!id.equals(objetSortieDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,objetSortieDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ObjetSortieDTO objetSortieDTO=service.getById(id);
		if(!id.equals(objetSortieDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
