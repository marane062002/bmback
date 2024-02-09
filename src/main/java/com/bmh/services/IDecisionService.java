package com.bmh.services;

import com.bmh.Models.controle_sanitaire.Decision;
import com.bmh.beans.controle_sanitaire.DecisionDTO;

import java.util.List;

public interface IDecisionService {
	Decision add(DecisionDTO decisionDTO);
	List<DecisionDTO> getAll();
	DecisionDTO getById(long id);
	void update(long id,DecisionDTO decisionDTO);
	void delete(long id);
}
