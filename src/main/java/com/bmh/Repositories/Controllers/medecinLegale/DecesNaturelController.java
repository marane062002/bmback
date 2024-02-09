package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.services.impl.medecinLegale.DecesNaturelService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/deces")
public class DecesNaturelController {
	private final DecesNaturelService service;
	private final ModelMapper mapper;

	public DecesNaturelController(DecesNaturelService service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<DecesNaturelDTO>> getAll(){
		List<DecesNaturelDTO> decesNaturelDTOS=service.getALl();
		return new ResponseEntity<>(decesNaturelDTOS, HttpStatus.OK);
	}
	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<DecesNaturelDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<DecesNaturelDTO> page = service.AllPagination(pageable);

		return new ResponseEntity<>(page, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<DecesNaturelDTO> Create(@RequestBody DecesNaturelDTO decesNaturelDTO){
		DecesNaturel decesNaturel = service.add(decesNaturelDTO);
		return new ResponseEntity<>(mapper.map(decesNaturel, DecesNaturelDTO.class), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<DecesNaturelDTO> getById(@PathVariable Long id) {
		DecesNaturelDTO decesNaturelDTO = service.getById(id);
		return new ResponseEntity<>(decesNaturelDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody DecesNaturelDTO decesNaturelDTO){
		DecesNaturelDTO decesNaturelDTO1=service.getById(id);
		if(!id.equals(decesNaturelDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,decesNaturelDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		DecesNaturelDTO decesNaturelDTO=service.getById(id);
		if(!id.equals(decesNaturelDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
