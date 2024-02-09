package com.bmh.services.impl;

import com.bmh.Models.Conducteur;
import com.bmh.Repositories.ConducteurRepository;
import com.bmh.beans.ConducteurDTO;
import com.bmh.services.IConducteurService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ConducteurServiceImpl implements IConducteurService {
	private final ConducteurRepository repository;

	private final Mapper mapper;

	public ConducteurServiceImpl(ConducteurRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Conducteur create(ConducteurDTO conducteurDTO) {
		return mapper.map(repository.save(mapper.map(conducteurDTO,Conducteur.class)),Conducteur.class);
	}

	@Override
	public List<ConducteurDTO> getAll() {
		return mapper.mapList(repository.findAll(),ConducteurDTO.class);
	}

	@Override
	public ConducteurDTO getById(long id) {
		Conducteur conducteur=repository.findById(id).get();
		return mapper.map(conducteur,ConducteurDTO.class);
	}

	@Override
	public void update(long id, ConducteurDTO conducteurDTO) {
		Optional<Conducteur> conducteur=repository.findById(id);
		if(conducteur.isPresent()){
			Conducteur exestingConducteur=conducteur.get();
			exestingConducteur.setNom(conducteurDTO.getNom());
			exestingConducteur.setPrenom(conducteurDTO.getPrenom());
			exestingConducteur.setCin(conducteurDTO.getCin());
			exestingConducteur.setTel(conducteurDTO.getTel());
			repository.save(exestingConducteur);
		}

	}

	@Override
	public void delete(long id) {
		Optional<Conducteur> conducteur=repository.findById(id);
		if(conducteur.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}

	}
}
