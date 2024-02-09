package com.bmh.services;

import com.bmh.Models.controle_sanitaire.TypeAnalyse;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;

import java.util.List;

public interface ITypeAnalyseService {
	TypeAnalyse add(TypeAnalyseDTO typeAnalyseDTO);
	List<TypeAnalyseDTO> getAll();
	TypeAnalyseDTO getById(long id);
	void update(long id,TypeAnalyseDTO typeAnalyseDTO);
	void delete(long id);
}
