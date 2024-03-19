package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.AutopsieDTO;
import com.bmh.beans.medecinLegale.OrganismeDTO;
import com.bmh.beans.medecinLegale.PrelevementDTO;
import com.bmh.services.impl.medecinLegale.PrelevementServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/prlv")
public class PrelevementController {
	private final PrelevementServiceImpl service;

	public PrelevementController(PrelevementServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<PrelevementDTO>> getAll(){
		List<PrelevementDTO> prelevementDTOS=service.getALl();
		return new ResponseEntity<>(prelevementDTOS, HttpStatus.OK);
	}

	@GetMapping("/statistics-prelvements")
	public List<Map<String, Object>> countPrelevementsBySexeAndAnalyseType() {
		return service.countPrelevementsBySexeAndAnalyseType();
	}

	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody PrelevementDTO prelevementDTO){
		service.add(prelevementDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<PrelevementDTO> getById(@PathVariable Long id) {
		PrelevementDTO prelevementDTO = service.getById(id);
		return new ResponseEntity<>(prelevementDTO, HttpStatus.OK);
	}
	@GetMapping("/obstacle/{id}")
	public ResponseEntity<List<PrelevementDTO>> getByIdObstacle(@PathVariable Long id){
		List<PrelevementDTO> prelevementDTOS=service.getByIdObstacle(id);
		return new ResponseEntity<>(prelevementDTOS,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody PrelevementDTO prelevementDTO){
		PrelevementDTO prelevementDTO1=service.getById(id);
		if(!id.equals(prelevementDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,prelevementDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		PrelevementDTO prelevementDTO=service.getById(id);
		if(!id.equals(prelevementDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
