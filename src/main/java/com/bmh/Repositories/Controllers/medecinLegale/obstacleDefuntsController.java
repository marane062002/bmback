package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.ObstacleDefuntsDTO;
import com.bmh.services.impl.medecinLegale.ObstacleDefuntsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/defunt")
public class obstacleDefuntsController {
	private final ObstacleDefuntsServiceImpl service;
	private final ModelMapper mapper;

	public obstacleDefuntsController(ObstacleDefuntsServiceImpl service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/count-defunts")
	public List<Map<String, Object>> countDefuntsByNationaliteAndSexe() {
		return service.countDefuntsByNationaliteAndSexe();
	}

	@GetMapping
	public ResponseEntity<List<ObstacleDefuntsDTO>> getAll(){
		List<ObstacleDefuntsDTO> obstacleDefuntsDTOS=service.getALl();
		return new ResponseEntity<>(obstacleDefuntsDTOS, HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<EmployeDto> Create(@RequestPart(name = "employe") EmployeDto employeDto,
//											 @RequestPart(name = "pieceJointe") MultipartFile pieceJointe,
//											 @RequestPart(name = "photo") MultipartFile photo) {
//		Employe employe = employeService.add(employeDto, pieceJointe, photo);
//		EmployeDto responseDto = mapper.map(employe, EmployeDto.class);
//		return new ResponseEntity<>(responseDto, HttpStatus.OK);
//	}
	@PostMapping
	public ResponseEntity<ObstacleDefuntsDTO> Create(@RequestPart(name = "infos") ObstacleDefuntsDTO obstacleDefuntsDTO){
		ObstacleDefunts obstacleDefunts = service.add(obstacleDefuntsDTO);
//		ObstacleDefuntsDTO defuntsDTO = mapper.map(obstacleDefunts,ObstacleDefuntsDTO.class);
//		return new ResponseEntity<>(obstacleDefuntsDTO, HttpStatus.OK);
//		Employeur employeur = iEmployeur.add(employeurDto, pieceJointes);
		return new ResponseEntity<>(mapper.map(obstacleDefunts,ObstacleDefuntsDTO.class), HttpStatus.OK);
	}

	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<ObstacleDefuntsDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize,
			@RequestParam(required = false) String dateDeces,
			@RequestParam(required = false) Arrondissement arrondissement,
			@RequestParam(required = false) StatusCadavre statusCadavre
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		LocalDate parsedDateDeces = null;
		if (dateDeces != null && !dateDeces.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			parsedDateDeces = LocalDate.parse(dateDeces, formatter);
		}
		Page<ObstacleDefuntsDTO> page = service.getAllPaginationWithFilter(parsedDateDeces, arrondissement, statusCadavre, pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ObstacleDefuntsDTO> getById(@PathVariable Long id) {
		ObstacleDefuntsDTO obstacleDefuntsDTO = service.getById(id);
		return new ResponseEntity<>(obstacleDefuntsDTO, HttpStatus.OK);
	}
//	@PutMapping("/{id}")
//	public ResponseEntity<Void> update(@PathVariable Long id,
//									   @RequestPart(name = "employe") EmployeDto employeDto,
//									   @RequestPart(name = "pieceJointe") MultipartFile pieceJointe,
//									   @RequestPart(name = "photo") MultipartFile photo) {
//		employeService.update(id, employeDto, pieceJointe, photo);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestPart(name = "infos") ObstacleDefuntsDTO obstacleDefuntsDTO){
		service.update(id,obstacleDefuntsDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ObstacleDefuntsDTO obstacleDefuntsDTO=service.getById(id);
		if(!id.equals(obstacleDefuntsDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
