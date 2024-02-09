package com.bmh.services.impl;

import com.bmh.Models.Constateur;
import com.bmh.beans.ConstateurDTO;
import com.bmh.beans.constateur1DTO;

import java.util.List;

public interface IConstateurService {
	Constateur add(ConstateurDTO constateurDTO);
	void update(ConstateurDTO constateurDTO,long id);
	void delete(long id);
	List<ConstateurDTO> getAll();
	ConstateurDTO getById(long id);
	constateur1DTO getById1(long id);
}
