package com.bmh.services;

import com.bmh.Models.Quantite;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.QuantiteDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IQuantiteService {
	Quantite add(QuantiteDTO quantiteDTO);
	List<QuantiteDTO> getALl();
	QuantiteDTO getById(long id);
	void update(long id,QuantiteDTO quantiteDTO);
	void delete(long id);
}
