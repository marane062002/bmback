package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.AutopsieDTO;
import com.bmh.beans.medecinLegale.PrelevementDTO;
import com.bmh.services.impl.medecinLegale.AutopsieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/autopsie")
public class AutopsieController {
	private final AutopsieServiceImpl service;

	public AutopsieController(AutopsieServiceImpl service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<AutopsieDTO>> getAll(){
		List<AutopsieDTO> autopsieDTOS=service.getALl();
		return new ResponseEntity<>(autopsieDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody AutopsieDTO autopsieDTO){
		service.add(autopsieDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AutopsieDTO> getById(@PathVariable Long id) {
		AutopsieDTO autopsieDTO = service.getById(id);
		return new ResponseEntity<>(autopsieDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody AutopsieDTO autopsieDTO){
		AutopsieDTO autopsieDTO1=service.getById(id);
		if(!id.equals(autopsieDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,autopsieDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		AutopsieDTO autopsieDTO=service.getById(id);
		if(!id.equals(autopsieDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
