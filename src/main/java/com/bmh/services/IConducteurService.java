package com.bmh.services;

import com.bmh.Models.Conducteur;
import com.bmh.beans.ConducteurDTO;

import java.util.List;

public interface IConducteurService{
	Conducteur create(ConducteurDTO conducteurDTO);
	List<ConducteurDTO> getAll();
	ConducteurDTO getById(long id);
	void update(long id,ConducteurDTO conducteurDTO);
	void delete(long id);
}
