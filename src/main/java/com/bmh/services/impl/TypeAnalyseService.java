package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.TypeAnalyse;
import com.bmh.Repositories.TypeAnalyseRepository;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.services.ITypeAnalyseService;
import com.bmh.services.Mapper;
import jdk.internal.joptsimple.internal.OptionNameMap;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TypeAnalyseService implements ITypeAnalyseService {
	private final TypeAnalyseRepository repository;
	private Mapper mapper;

	public TypeAnalyseService(TypeAnalyseRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TypeAnalyse add(TypeAnalyseDTO typeAnalyseDTO) {
		return mapper.map(repository.save(mapper.map(typeAnalyseDTO, TypeAnalyse.class)), TypeAnalyse.class);
	}

	@Override
	public List<TypeAnalyseDTO> getAll() {
		return mapper.mapList(repository.findAll(),TypeAnalyseDTO.class);
	}

	@Override
	public TypeAnalyseDTO getById(long id) {
		TypeAnalyse typeAnalyse=repository.findById(id).get();
		return mapper.map(typeAnalyse,TypeAnalyseDTO.class);
	}

	@Override
	public void update(long id, TypeAnalyseDTO typeAnalyseDTO) {
		Optional<TypeAnalyse> typeAnalyse=repository.findById(id);
		if(typeAnalyse.isPresent()){
			TypeAnalyse typeAnalyse1=typeAnalyse.get();
			typeAnalyse1.setLibelle(typeAnalyseDTO.getLibelle());
			typeAnalyse1.setDescription(typeAnalyseDTO.getDescription());
			repository.save(typeAnalyse1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<TypeAnalyse> typeAnalyse=repository.findById(id);
		if(typeAnalyse.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
