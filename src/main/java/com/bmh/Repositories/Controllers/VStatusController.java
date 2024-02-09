package com.bmh.Repositories.Controllers;

import com.bmh.beans.StatusDTO;
import com.bmh.services.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/vstatus")
public class VStatusController {
	private  final IStatusService service;

	@Autowired
	public VStatusController(IStatusService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<StatusDTO>> getAll(){
		List<StatusDTO> statusDTO=service.getAll();
		return new ResponseEntity<>(statusDTO, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<StatusDTO> getById(@PathVariable Long id){
		StatusDTO statusDTO=service.getById(id);
		return new ResponseEntity<>(statusDTO,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody StatusDTO statusDTO){
		service.create(statusDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody StatusDTO statusDTO){
		if(!id.equals(statusDTO.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,statusDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
