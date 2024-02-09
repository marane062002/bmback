package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.Decision;
import com.bmh.Repositories.DecisionRepositoy;
import com.bmh.beans.controle_sanitaire.DecisionDTO;
import com.bmh.services.IDecisionService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DecisionService implements IDecisionService {
	private final DecisionRepositoy repositoy;
	private Mapper mapper;

	public DecisionService(DecisionRepositoy repositoy, Mapper mapper) {
		this.repositoy = repositoy;
		this.mapper = mapper;
	}

	@Override
	public Decision add(DecisionDTO decisionDTO) {
		return mapper.map(repositoy.save(mapper.map(decisionDTO,Decision.class)),Decision.class);
	}

	@Override
	public List<DecisionDTO> getAll() {
		return mapper.mapList(repositoy.findAll(),DecisionDTO.class);
	}

	@Override
	public DecisionDTO getById(long id) {
		Decision decision=repositoy.findById(id).get();
		return mapper.map(decision,DecisionDTO.class);
	}

	@Override
	public void update(long id, DecisionDTO decisionDTO) {
		Optional<Decision> decision=repositoy.findById(id);
		if(decision.isPresent()){
			Decision decision1=decision.get();
			decision1.setLibelle(decisionDTO.getLibelle());
			decision1.setDescription(decisionDTO.getDescription());
			repositoy.save(decision1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Decision> decision=repositoy.findById(id);
		if(decision.isPresent()){
			repositoy.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
