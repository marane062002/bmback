package com.bmh.services;

import com.bmh.Models.Equipe;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.EquipeDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IEquipeService {
	Equipe add(EquipeDTO equipeDTO);
	List<EquipeDTO> getALl();
	EquipeDTO getById(long id);
	void update(long id,EquipeDTO equipeDTO);
	void delete(long id);
}
