package com.bmh.services;

import com.bmh.Models.ProduitUtilise;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.ProduitUtiliseDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IProduitUtiliseService {
	ProduitUtilise add(ProduitUtiliseDTO produitUtiliseDTO);
	List<ProduitUtiliseDTO> getALl();
	ProduitUtiliseDTO getById(long id);
	void update(long id,ProduitUtiliseDTO produitUtiliseDTO);
	void delete(long id);
}
