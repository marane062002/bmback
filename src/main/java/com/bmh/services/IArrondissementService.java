package com.bmh.services;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IArrondissementService {
	Arrondissement add(ArrondissementDTO arrondissementDTO);
	List<ArrondissementDTO> getALl();
	ArrondissementDTO getById(long id);
	void update(long id,ArrondissementDTO arrondissementDTO);
	void delete(long id);
}
