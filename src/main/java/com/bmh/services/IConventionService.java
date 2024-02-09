package com.bmh.services;

import com.bmh.Models.controle_sanitaire.Convention;
import com.bmh.beans.controle_sanitaire.ConventionDTO;

import java.util.List;

public interface IConventionService {
	Convention add(ConventionDTO conventionDTO);
	List<ConventionDTO> getAll();
	ConventionDTO getById(long id);
	void update(long id,ConventionDTO conventionDTO);
	void delete(long id);
}
