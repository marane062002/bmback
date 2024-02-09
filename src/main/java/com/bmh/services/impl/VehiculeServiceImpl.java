package com.bmh.services.impl;

import com.bmh.Models.Vehicule;
import com.bmh.Repositories.VehiculeRepository;
import com.bmh.beans.VehiculeDTO;
import com.bmh.services.IVehiculeService;
import com.bmh.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VehiculeServiceImpl implements IVehiculeService {
	private final VehiculeRepository repository;
	private Mapper mapper;

	@Autowired
	public VehiculeServiceImpl(VehiculeRepository repository,Mapper mapper) {
		this.repository = repository;
		this.mapper=mapper;
	}

	@Override
	public Vehicule create(VehiculeDTO vehiculeDTO) {
		return mapper.map(repository.save(mapper.map(vehiculeDTO, Vehicule.class)), Vehicule.class);
	}

	@Override
	public List<VehiculeDTO> getAll() {
		return mapper.mapList(repository.findAll(),VehiculeDTO.class);
	}

	@Override
	public VehiculeDTO getById(long id) {
		Vehicule vehicule=repository.findById(id).get();
		return mapper.map(vehicule, VehiculeDTO.class);
	}

	@Override
	public void update(long id, VehiculeDTO vehiculeDTO) {
		Optional<Vehicule> vehicule=repository.findById(id);
		if(vehicule.isPresent()){
			Vehicule exestingVehicule=vehicule.get();
			exestingVehicule.setDescription(vehiculeDTO.getDescription());
			exestingVehicule.setLibelle(vehiculeDTO.getLibelle());
			repository.save(exestingVehicule);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Vehicule> vehicule=repository.findById(id);
		if(vehicule.isPresent()){
			repository.deleteById(id);
		}

	}
}
