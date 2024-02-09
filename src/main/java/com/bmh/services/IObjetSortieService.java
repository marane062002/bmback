package com.bmh.services;

import com.bmh.Models.ObjetSortie;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.ObjetSortieDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IObjetSortieService {
	ObjetSortie add(ObjetSortieDTO objetSortieDTO);
	List<ObjetSortieDTO> getALl();
	ObjetSortieDTO getById(long id);
	void update(long id,ObjetSortieDTO objetSortieDTO);
	void delete(long id);
}
