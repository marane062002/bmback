package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Models.medecinLegale.Origine;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.beans.medecinLegale.OrigineDTO;
import com.bmh.services.impl.medecinLegale.OrigineServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/origine")
public class OrigineController {
	private final OrigineServiceImpl service;

	private ModelMapper mapper;

	public OrigineController(OrigineServiceImpl service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	@GetMapping
	public ResponseEntity<List<OrigineDTO>> getAll(){
		List<OrigineDTO> origineDTOS=service.getALl();
		return new ResponseEntity<>(origineDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<OrigineDTO> Create(@RequestBody OrigineDTO origineDTO){
		Origine origine = service.add(origineDTO);
		OrigineDTO responseDto = mapper.map(origine, OrigineDTO.class);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<OrigineDTO> getById(@PathVariable Long id) {
		OrigineDTO origineDTO = service.getById(id);
		return new ResponseEntity<>(origineDTO, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrigineDTO> update(@PathVariable Long id,@RequestBody OrigineDTO origineDTO){
		OrigineDTO origineDTO1=service.getById(id);
		if(!id.equals(origineDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,origineDTO);
			return new ResponseEntity<>(origineDTO, HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		OrigineDTO origineDTO=service.getById(id);
		if(!id.equals(origineDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
