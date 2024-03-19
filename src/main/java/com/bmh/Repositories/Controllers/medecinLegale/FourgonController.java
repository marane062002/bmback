package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.MorgueDTO;
import com.bmh.services.impl.medecinLegale.FourgonServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/fourgon")
public class FourgonController {
	private final FourgonServiceImpl service;
	private final ModelMapper mapper;

	public FourgonController(FourgonServiceImpl service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<FourgonDTO>> getAll(){
		List<FourgonDTO> fourgonDTOS=service.getALl();
		return new ResponseEntity<>(fourgonDTOS, HttpStatus.OK);
	}

	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<FourgonDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<FourgonDTO> page = service.AllPagination(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FourgonDTO> getById(@PathVariable Long id){
		FourgonDTO fourgonDTO=service.getById(id);
		return new ResponseEntity<>(fourgonDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<FourgonDTO> create(@RequestPart(name = "fourgon") FourgonDTO fourgonDTO){
		Fourgon fourgon = service.add(fourgonDTO);
		return new ResponseEntity<>(mapper.map(fourgon, FourgonDTO.class), HttpStatus.OK);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestPart(name = "fourgon") FourgonDTO fourgonDTO){
		service.update(id, fourgonDTO);
		return  new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		FourgonDTO fourgonDTO=service.getById(id);
		if(!id.equals(fourgonDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
