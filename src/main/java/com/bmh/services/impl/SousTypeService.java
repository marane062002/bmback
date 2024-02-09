package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.SousType;
import com.bmh.Repositories.SousTypeRepository;
import com.bmh.beans.controle_sanitaire.SousTypeDTO;
import com.bmh.services.ISousTypeService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SousTypeService implements ISousTypeService {
	private final SousTypeRepository repository;
	private Mapper mapper;

	public SousTypeService(SousTypeRepository repository,Mapper mapper) {
		this.repository = repository;
		this.mapper=mapper;
	}

	@Override
	public SousType add(SousTypeDTO sousTypeDTO) {
		return mapper.map(repository.save(mapper.map(sousTypeDTO, SousType.class)),SousType.class) ;
	}

	@Override
	public List<SousTypeDTO> getAll() {
		return mapper.mapList(repository.findAll(), SousTypeDTO.class);
	}

	@Override
	public SousTypeDTO getById(long id) {
		SousType sousType=repository.findById(id).get();
		return mapper.map(sousType,SousTypeDTO.class);
	}

	@Override
	public void update(long id, SousTypeDTO sousTypeDTO) {
		Optional<SousType> sousType=repository.findById(id);
		if(sousType.isPresent()){
			SousType sousType1=sousType.get();
			sousType1.setLibelle(sousTypeDTO.getLibelle());
			sousType1.setDescription(sousType1.getDescription());
			repository.save(sousType1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<SousType> sousType=repository.findById(id);
		if(sousType.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
