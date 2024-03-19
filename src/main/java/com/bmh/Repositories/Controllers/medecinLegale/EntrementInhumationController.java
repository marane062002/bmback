package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.EnterrementObstacleDTO;
import com.bmh.beans.medecinLegale.EntrementInhumationDTO;
import com.bmh.services.carteSanitaire.IEmployeur;
import com.bmh.services.impl.medecinLegale.EntrementInhumationServiceImpl;
import com.bmh.services.medecinLegale.EntrementInhumationService;
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
@RequestMapping("/enterrement")
public class EntrementInhumationController {
	private final EntrementInhumationService entrementInhumationService;
	private final ModelMapper mapper;

	public EntrementInhumationController(EntrementInhumationService entrementInhumationService, ModelMapper mapper) {
		this.entrementInhumationService = entrementInhumationService;
		this.mapper = mapper;
	}

	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<EntrementInhumationDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<EntrementInhumationDTO> page = entrementInhumationService.AllPagination(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	};


	@GetMapping
	public ResponseEntity<List<EntrementInhumationDTO>> getAll(){
		List<EntrementInhumationDTO> entrementInhumationDTOS=entrementInhumationService.getALl();
		return new ResponseEntity<>(entrementInhumationDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<EntrementInhumationDTO> create(
			@RequestPart(name = "enterement") EntrementInhumationDTO entrementInhumationDTO) {
		EntrementInhumation entrementInhumation = entrementInhumationService.add(entrementInhumationDTO);
		return new ResponseEntity<>(mapper.map(entrementInhumation, EntrementInhumationDTO.class), HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<EntrementInhumationDTO> getById(@PathVariable Long id) {
		EntrementInhumationDTO entrementInhumationDTO = entrementInhumationService.getById(id);
		return new ResponseEntity<>(entrementInhumationDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,
									   @RequestPart(name = "enterement") EntrementInhumationDTO entrementInhumationDTO){
		entrementInhumationService.update(id, entrementInhumationDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		entrementInhumationService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
