package com.bmh.Repositories.Controllers.medecinLegale;

import com.bmh.Models.medecinLegale.Morgue;
//import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.medecinLegale.MorgueDTO;
import com.bmh.services.impl.medecinLegale.MorgueServiceImpl;
import org.modelmapper.ModelMapper;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/morgue")
public class MorgueController {
	private final MorgueServiceImpl service;
	private final ModelMapper mapper;

	public MorgueController(MorgueServiceImpl service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<MorgueDTO>> getAll(){
		List<MorgueDTO> morgueDTOS=service.getALl();
		return new ResponseEntity<>(morgueDTOS, HttpStatus.OK);
	}

	@GetMapping("/paginate/{pageNo}/{pageSize}")
	public ResponseEntity<Page<MorgueDTO>> getAllwithPaginate(
			@PathVariable int pageNo,
			@PathVariable int pageSize
	) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<MorgueDTO> page = service.AllPagination(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

//	@GetMapping("/paginate/{pageNo}/{pageSize}")
//	public ResponseEntity<Page<ObstacleDefuntsDTO>> getAllwithPaginate(
//			@PathVariable int pageNo,
//			@PathVariable int pageSize
//	) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
//
//		Page<ObstacleDefuntsDTO> page = service.AllPagination(pageable);
//
//		return new ResponseEntity<>(page, HttpStatus.OK);
//	}
	@GetMapping("/{id}")
	public ResponseEntity<MorgueDTO> getById(@PathVariable Long id){
		MorgueDTO morgueDTO=service.getById(id);
		return new ResponseEntity<>(morgueDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<MorgueDTO> create(@RequestPart(name = "morgue") MorgueDTO morgueDTO , @RequestPart(name = "pcj")MultipartFile pcJointe){
		Morgue morgue = service.add(morgueDTO, pcJointe);
		return new ResponseEntity<>(mapper.map(morgue, MorgueDTO.class), HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody MorgueDTO morgueDTO){
		service.update(id, morgueDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		MorgueDTO morgueDTO=service.getById(id);
		if(!id.equals(morgueDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
