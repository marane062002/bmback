package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.InformationSecesConstateurDTO;
import com.bmh.services.impl.medecinLegale.InformationSecesConstateurServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/infConst")
public class informationSecesConstateurController {
	private final InformationSecesConstateurServiceImpl service;

	public informationSecesConstateurController(InformationSecesConstateurServiceImpl service) {

		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<InformationSecesConstateurDTO>> getAll(){
		List<InformationSecesConstateurDTO> informationSecesConstateurDTOS=service.getALl();
		return new ResponseEntity<>(informationSecesConstateurDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody InformationSecesConstateurDTO informationSecesConstateurDTO){
		service.add(informationSecesConstateurDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<InformationSecesConstateurDTO> getById(@PathVariable Long id) {
		InformationSecesConstateurDTO informationSecesConstateurDTO = service.getById(id);
		return new ResponseEntity<>(informationSecesConstateurDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody InformationSecesConstateurDTO informationSecesConstateurDTO){
		InformationSecesConstateurDTO informationSecesConstateurDTO1=service.getById(id);
		if(!id.equals(informationSecesConstateurDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,informationSecesConstateurDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		InformationSecesConstateurDTO informationSecesConstateurDTO=service.getById(id);
		if(!id.equals(informationSecesConstateurDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
