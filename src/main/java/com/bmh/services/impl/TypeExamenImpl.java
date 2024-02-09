package com.bmh.services.impl;

import com.bmh.Models.Constateur;
import com.bmh.Models.TypeExamen;
import com.bmh.Repositories.ITypeExamenRepository;
import com.bmh.beans.TypeExamenDTO;
import com.bmh.services.ITypeExamenService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class TypeExamenImpl implements ITypeExamenService{

	private final ITypeExamenRepository repository;

	private final Mapper mapper;
	public TypeExamenImpl(ITypeExamenRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TypeExamen add(TypeExamenDTO typeExamenDTO) {
		return mapper.map(repository.save(mapper.map(typeExamenDTO,TypeExamen.class)),TypeExamen.class);
	}

	@Override
	public List<TypeExamenDTO> getAll() {
		return mapper.mapList(repository.findAll(),TypeExamenDTO.class);
	}

	@Override
	public void delete(long id) {
		Optional<TypeExamen> constOptional=repository.findById(id);
		if(constOptional.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("Type avec l'ID"+id+"n'a pas trouvee");
		}
	}

	@Override
	public void update(long id, TypeExamenDTO typeExamenDTO) {
		Optional<TypeExamen> typeExamen1=repository.findById(id);
		if(typeExamen1.isPresent()){
			TypeExamen exestingTypeExamen=typeExamen1.get();
			exestingTypeExamen.setLibelle(typeExamenDTO.getLibelle());
			exestingTypeExamen.setDescription(typeExamenDTO.getDescription());
			repository.save(exestingTypeExamen);
		}
	}

	@Override
	public TypeExamenDTO getById(long id) {
		TypeExamen typeExamen=repository.findById(id).get();
		return mapper.map(typeExamen,TypeExamenDTO.class);
	}
}
