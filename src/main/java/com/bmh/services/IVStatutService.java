package com.bmh.services;

import com.bmh.Models.VctStatut;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.VStatutDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IVStatutService {
	VctStatut add(VStatutDTO vStatutDTO);
	List<VStatutDTO> getALl();
	VStatutDTO getById(long id);
	void update(long id,VStatutDTO vStatutDTO);
	void delete(long id);
}
