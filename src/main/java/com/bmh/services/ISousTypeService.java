package com.bmh.services;

import com.bmh.Models.controle_sanitaire.SousType;
import com.bmh.beans.controle_sanitaire.SousTypeDTO;

import java.util.List;

public interface ISousTypeService {
	SousType add(SousTypeDTO sousTypeDTO);
	List<SousTypeDTO> getAll();
	SousTypeDTO getById(long id);
	void update(long id,SousTypeDTO sousTypeDTO);
	void delete(long id);
}
