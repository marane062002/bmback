package com.bmh.services.medecinLegale;

import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.Models.medecinLegale.Origine;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.medecinLegale.OrigineDTO;

import java.util.List;

public interface OrigineService {
	Origine add(OrigineDTO origineDTO);
	List<OrigineDTO> getALl();
	OrigineDTO getById(long id);
	void update(long id,OrigineDTO origineDTO);
	void delete(long id);
}
