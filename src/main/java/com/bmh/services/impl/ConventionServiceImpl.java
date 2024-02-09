package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.Convention;
import com.bmh.Repositories.ConventionRepository;
import com.bmh.beans.controle_sanitaire.ConventionDTO;
import com.bmh.services.IConventionService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ConventionServiceImpl implements IConventionService {
	private final ConventionRepository repository;
	private Mapper mapper;

	public ConventionServiceImpl(ConventionRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Convention add(ConventionDTO conventionDTO) {
		return mapper.map(repository.save(mapper.map(conventionDTO, Convention.class)),Convention.class);
	}

	@Override
	public List<ConventionDTO> getAll() {
		return mapper.mapList(repository.findAll(),ConventionDTO.class);
	}

	@Override
	public ConventionDTO getById(long id) {
		Convention convention=repository.findById(id).get();
		return mapper.map(convention, ConventionDTO.class);
	}

	@Override
	public void update(long id, ConventionDTO conventionDTO) {
		Optional<Convention> convention=repository.findById(id);
		if(convention.isPresent()){
			Convention convention1=convention.get();
			convention1.setLibelle(conventionDTO.getLibelle());
			convention1.setDescription(conventionDTO.getDescription());
			repository.save(convention1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Convention> convention=repository.findById(id);
		if(convention.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
