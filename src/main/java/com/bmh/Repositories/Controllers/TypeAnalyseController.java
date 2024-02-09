package com.bmh.Repositories.Controllers;

import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.services.ITypeAnalyseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/typeAnalyse")
public class TypeAnalyseController {
	private final ITypeAnalyseService service;

	public TypeAnalyseController(ITypeAnalyseService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<TypeAnalyseDTO>> getAll(){
		List<TypeAnalyseDTO> typeAnalyseDTOS=service.getAll();
		return new ResponseEntity<>(typeAnalyseDTOS, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TypeAnalyseDTO> getById(@PathVariable Long id){
		TypeAnalyseDTO typeAnalyseDTO=service.getById(id);
		return new ResponseEntity<>(typeAnalyseDTO,HttpStatus.OK);
	}
	@PostMapping
	public  ResponseEntity<Void> create(@RequestBody TypeAnalyseDTO typeAnalyseDTO){
		service.add(typeAnalyseDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TypeAnalyseDTO typeAnalyseDTO){
		TypeAnalyseDTO typeAnalyseDTO1=service.getById(id);
		if(!id.equals(typeAnalyseDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,typeAnalyseDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TypeAnalyseDTO typeAnalyseDTO1=service.getById(id);
		if(!id.equals(typeAnalyseDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
