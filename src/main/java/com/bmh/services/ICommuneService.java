package com.bmh.services;

import com.bmh.Models.Commune;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.CommuneDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface ICommuneService {
	Commune add(CommuneDTO communeDTO);
	List<CommuneDTO> getALl();
	CommuneDTO getById(long id);
	void update(long id,CommuneDTO communeDTO);
	void delete(long id);
}
