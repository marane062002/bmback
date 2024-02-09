package com.bmh.services;

import com.bmh.Models.controle_sanitaire.TypeControleSanitaire;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.beans.controle_sanitaire.TypeControleDTO;

import java.util.List;

public interface ITypeControleService {

	TypeControleSanitaire add(TypeControleDTO typeControleDTO);
	List<TypeControleDTO> getAll();
	TypeControleDTO getById(long id);
	void update(long id,TypeControleDTO typeControleDTO);
	void delete(long id);
}
