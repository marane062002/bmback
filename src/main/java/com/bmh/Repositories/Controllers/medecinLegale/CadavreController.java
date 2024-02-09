package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.CadavreDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.services.impl.medecinLegale.CadavreServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/cadavre")
public class CadavreController {
	private final CadavreServiceImpl service;

	public CadavreController(CadavreServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<CadavreDTO>> getAll(){
		List<CadavreDTO> cadavreDTOS=service.getALl();
		return new ResponseEntity<>(cadavreDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CadavreDTO> getById(@PathVariable Long id){
		CadavreDTO cadavreDTO=service.getById(id);
		return new ResponseEntity<>(cadavreDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CadavreDTO cadavreDTO){
		service.add(cadavreDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody CadavreDTO cadavreDTO){
		CadavreDTO cadavreDTO1=service.getById(id);
		if(!id.equals(cadavreDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,cadavreDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		CadavreDTO cadavreDTO=service.getById(id);
		if(!id.equals(cadavreDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
