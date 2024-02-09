package com.bmh.Repositories.Controllers;

import com.bmh.beans.ConducteurDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.services.IAgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/agent")
public class AgentController {
	private final IAgentService service;

	public AgentController(IAgentService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<AgentDTO>> getAll(){
		List<AgentDTO> agentDTOS=service.getALl();
		return new ResponseEntity<>(agentDTOS, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody AgentDTO agentDTO){
		service.add(agentDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AgentDTO> getById(@PathVariable Long id) {
		AgentDTO agentDTO = service.getById(id);
		return new ResponseEntity<>(agentDTO, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody AgentDTO agentDTO){
		AgentDTO agentDTO1=service.getById(id);
		if(!id.equals(agentDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.update(id,agentDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		AgentDTO agentDTO1=service.getById(id);
		if(!id.equals(agentDTO1.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
