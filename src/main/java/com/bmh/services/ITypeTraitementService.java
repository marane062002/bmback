package com.bmh.services;

import com.bmh.Models.TypeTraitement;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.TypeTraitementDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface ITypeTraitementService {
	TypeTraitement add(TypeTraitementDTO typeTraitementDTO);
	List<TypeTraitementDTO> getALl();
	TypeTraitementDTO getById(long id);
	void update(long id,TypeTraitementDTO typeTraitementDTO);
	void delete(long id);
}
