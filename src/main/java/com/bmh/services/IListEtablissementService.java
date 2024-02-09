package com.bmh.services;

import com.bmh.Models.controle_sanitaire.ListEtablissement;
import com.bmh.beans.controle_sanitaire.ListEtablissementDTO;

import java.util.List;

public interface IListEtablissementService {
	ListEtablissement add(ListEtablissementDTO listEtablissementDTO);
	List<ListEtablissementDTO> getAll();
	ListEtablissementDTO getById(long id);
	void update(long id,ListEtablissementDTO listEtablissementDTO);
	void delete(long id);
}
