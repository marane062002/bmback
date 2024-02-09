package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.NouveauNeDTO;
import com.bmh.Models.medecinLegale.NouveauNe;
import com.bmh.services.impl.medecinLegale.NouveauNeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/nouveauNe")
public class NouveauNeController {
	private final NouveauNeServiceImpl service;

	public NouveauNeController(NouveauNeServiceImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<NouveauNeDTO>> getAll(){
		List<NouveauNeDTO> nouveauNeDTOS=service.getALl();
		return new ResponseEntity<>(nouveauNeDTOS, HttpStatus.OK);
	}

	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<NouveauNeDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<NouveauNeDTO> page = service.AllPagination(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NouveauNeDTO> getById(@PathVariable Long id){
		NouveauNeDTO nouveauNeDTO=service.getById(id);
		return new ResponseEntity<>(nouveauNeDTO,HttpStatus.OK);
	}
	@PostMapping
	public NouveauNe create(@RequestBody NouveauNeDTO nouveauNeDTO){
		NouveauNe nouveauNe =service.add(nouveauNeDTO);
		return nouveauNe;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody NouveauNeDTO nouveauNeDTO){
		NouveauNeDTO nouveauNeDTO1=service.getById(id);
		if(!id.equals(nouveauNeDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,nouveauNeDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		NouveauNeDTO nouveauNeDTO=service.getById(id);
		if(!id.equals(nouveauNeDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
