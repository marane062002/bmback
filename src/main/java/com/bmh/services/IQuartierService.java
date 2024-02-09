package com.bmh.services;

import com.bmh.Models.Quartier;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.QuantiteDTO;
import com.bmh.beans.QuartierDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IQuartierService {
	Quartier add(QuartierDTO quartierDTO);
	List<QuartierDTO> getALl();
	QuartierDTO getById(long id);
	void update(long id,QuartierDTO quartierDTO);
	void delete(long id);
}
