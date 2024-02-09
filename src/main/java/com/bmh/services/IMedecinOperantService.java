package com.bmh.services;

import com.bmh.Models.MedecinOperant;
import com.bmh.beans.MedecinOperantDTO;

import java.util.List;

public interface IMedecinOperantService {
	MedecinOperant add(MedecinOperantDTO medecinOperantDTO);
	List<MedecinOperantDTO> getAll();
	MedecinOperantDTO getById(long id);
	void update(long id,MedecinOperantDTO medecinOperantDTO);
	void delete(long id);

}
