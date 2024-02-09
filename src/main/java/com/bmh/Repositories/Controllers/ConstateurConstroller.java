package com.bmh.Repositories.Controllers;

import com.bmh.beans.ConstateurDTO;
import com.bmh.beans.constateur1DTO;
import com.bmh.services.impl.ConstateurImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/constateur")
public class ConstateurConstroller {
	private final ConstateurImpl service;
	@Autowired
	public ConstateurConstroller(ConstateurImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<ConstateurDTO>> getAllConstateur(){
		List<ConstateurDTO> constateur=service.getAll();
		return new ResponseEntity<>(constateur, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ConstateurDTO> getConstateurById(@PathVariable Long id){
			ConstateurDTO constDTO= service.getById(id);
			return new ResponseEntity<>(constDTO,HttpStatus.OK);
	}

	@GetMapping("/constrateur/{id}")
	public ResponseEntity<constateur1DTO> getConstateurById1(@PathVariable Long id){
		constateur1DTO constDTO= service.getById1(id);
		return new ResponseEntity<>(constDTO,HttpStatus.OK);

	}
	@PostMapping
	public ResponseEntity<Void> addConstateur(@RequestBody ConstateurDTO constateurDTO){
		service.add(constateurDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public 	ResponseEntity<ConstateurDTO> updateConstateur(@PathVariable Long id,@RequestBody ConstateurDTO constateurDto){
		if(!id.equals(constateurDto.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			service.update(constateurDto, id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteConstateur(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
