package com.bmh.services;

import com.bmh.Models.TVacation;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.TVacationDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface ITVacationService {
	TVacation add(TVacationDTO tVacationDTO);
	List<TVacationDTO> getALl();
	TVacationDTO getById(long id);
	void update(long id,TVacationDTO tVacationDTO);
	void delete(long id);
}
