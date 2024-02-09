package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.ConstateurNouveauNeDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.services.impl.medecinLegale.ConstateurNouveauNeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/constateurNv")
public class ConstateurNouveauNeController {
	private final ConstateurNouveauNeServiceImpl service;

	public ConstateurNouveauNeController(ConstateurNouveauNeServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ConstateurNouveauNeDTO>> getAll(){
		List<ConstateurNouveauNeDTO> constateurNouveauNeDTOS=service.getALl();
		return new ResponseEntity<>(constateurNouveauNeDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ConstateurNouveauNeDTO> getById(@PathVariable Long id){
		ConstateurNouveauNeDTO constateurNouveauNeDTO=service.getById(id);
		return new ResponseEntity<>(constateurNouveauNeDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ConstateurNouveauNeDTO constateurNouveauNeDTO){
		service.add(constateurNouveauNeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ConstateurNouveauNeDTO constateurNouveauNeDTO){
		ConstateurNouveauNeDTO constateurNouveauNeDTO1=service.getById(id);
		if(!id.equals(constateurNouveauNeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,constateurNouveauNeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ConstateurNouveauNeDTO constateurNouveauNeDTO=service.getById(id);
		if(!id.equals(constateurNouveauNeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
