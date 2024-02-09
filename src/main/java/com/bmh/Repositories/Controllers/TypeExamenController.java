package com.bmh.Repositories.Controllers;

import com.bmh.beans.TypeExamenDTO;
import com.bmh.services.impl.TypeExamenImpl;
import org.docx4j.wml.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/examen")
public class TypeExamenController {

	@Autowired
	private final TypeExamenImpl service;

	public TypeExamenController(TypeExamenImpl service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TypeExamenDTO>> getAllTE(){
		List<TypeExamenDTO> typeExamenDTOS=service.getAll();
		return new ResponseEntity<>(typeExamenDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<TypeExamenDTO> createT(@RequestBody TypeExamenDTO typeExamenDTO){
		service.add(typeExamenDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<TypeExamenDTO> updateT(@PathVariable Long id,@RequestBody TypeExamenDTO typeExamenDTO){
		if(!id.equals(typeExamenDTO.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else{
			service.update(id,typeExamenDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TypeExamenDTO> getById(@PathVariable Long id){
			TypeExamenDTO typeExamenDTO=service.getById(id);
			return new ResponseEntity<>(typeExamenDTO,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
