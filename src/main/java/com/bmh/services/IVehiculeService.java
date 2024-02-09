package com.bmh.services;

import com.bmh.Models.Vehicule;
import com.bmh.beans.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {
	Vehicule create(VehiculeDTO vehiculeDTO);
	List<VehiculeDTO> getAll();
	VehiculeDTO getById(long id);
	void update(long id,VehiculeDTO vehiculeDTO);
	void delete(long id);
}
