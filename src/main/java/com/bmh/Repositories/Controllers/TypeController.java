package com.bmh.Repositories.Controllers;

import com.bmh.Models.Type;
import com.bmh.beans.TypeDto;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.services.impl.TypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.tools.jconsole.JConsole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/type")
public class TypeController {
  private final TypeServiceImpl service;
	private final Logger logger = LoggerFactory.getLogger(Type.class);

    @Autowired
    public TypeController(TypeServiceImpl service) {
        this.service = service;
    }

  /*  @GetMapping("/all")
    public ResponseEntity<List<TypeDto>> getAllTypes(Pageable p){
        List<TypeDto> type=service.getAll();
        return new ResponseEntity<>(type, HttpStatus.OK);
    }*/
  @GetMapping
  public ResponseEntity<List<TypeDto>> getAllTypes() {
	  List<TypeDto> typeAnalyseDTOS=service.getAll();
	  return new ResponseEntity<>(typeAnalyseDTOS, HttpStatus.OK);
  }


	@PostMapping
    public ResponseEntity<Void> addType(@RequestBody TypeDto typeDto){
        service.add(typeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateType(@PathVariable Long id,@RequestBody TypeDto typeDto){
        if(!id.equals(typeDto.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            service.update(typeDto,id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TypeDto> getTypeById(@PathVariable Long id){
//        TypeDto typeDto=service.getById(id);
//        if(typeDto !=null){
//            return new ResponseEntity<>(typeDto,HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
	@GetMapping("/{id}")
	public TypeDto getTypeById(@PathVariable Long id) {
		TypeDto typeDto = service.getById(id);
		return typeDto;
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	/*@GetMapping("/search")
	public List<Type> searchTypes(@RequestParam("keyword") String keyword) {
		return service.searchTypes(keyword);
	}*/
}
