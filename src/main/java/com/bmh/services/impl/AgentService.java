package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.Repositories.AgentRepository;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.services.IAgentService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AgentService implements IAgentService {
	private final AgentRepository repository;
	private Mapper mapper;

	public AgentService(AgentRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Agent add(AgentDTO agentDTO) {
		return mapper.map(repository.save(mapper.map(agentDTO, Agent.class)),Agent.class);
	}

	@Override
	public List<AgentDTO> getALl() {
		return mapper.mapList(repository.findAll(),AgentDTO.class);
	}

	@Override
	public AgentDTO getById(long id) {
		Agent agent=repository.findById(id).get();
		return mapper.map(agent,AgentDTO.class);
	}

	@Override
	public void update(long id, AgentDTO agentDTO) {
		Optional<Agent> agent=repository.findById(id);
		if(agent.isPresent()){
			Agent agent1=agent.get();
			agent1.setNom(agentDTO.getNom());
			agent1.setPrenom(agentDTO.getPrenom());
			agent1.setCin(agentDTO.getCin());
			agent1.setTel(agentDTO.getTel());
			repository.save(agent1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Agent> agent=repository.findById(id);
		if(agent.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
