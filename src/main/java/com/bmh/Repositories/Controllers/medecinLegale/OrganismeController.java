package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.OrganismeDTO;
import com.bmh.Models.medecinLegale.Organisme;
import com.bmh.services.medecinLegale.OrganismeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/organisme")
public class OrganismeController {
	private final OrganismeService service;

	public OrganismeController(OrganismeService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<OrganismeDTO>> getAll(){
		List<OrganismeDTO> organismeDTOS=service.getALl();
		return new ResponseEntity<>(organismeDTOS, HttpStatus.OK);
	}

	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<OrganismeDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<OrganismeDTO> page = service.AllPagination(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@PostMapping
	public Organisme Create(@RequestBody OrganismeDTO organismeDTO){

		Organisme organisme=service.add(organismeDTO);
		return organisme;
	}
	@GetMapping("/{id}")
	public ResponseEntity<OrganismeDTO> getById(@PathVariable Long id) {
		OrganismeDTO organismeDTO = service.getById(id);
		return new ResponseEntity<>(organismeDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody OrganismeDTO organismeDTO){
		OrganismeDTO organismeDTO1=service.getById(id);
		if(!id.equals(organismeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,organismeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		OrganismeDTO organismeDTO=service.getById(id);
		if(!id.equals(organismeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
