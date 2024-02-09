package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.TypeControleSanitaire;
import com.bmh.Repositories.TypeControleSanitaireRepository;
import com.bmh.beans.controle_sanitaire.TypeAnalyseDTO;
import com.bmh.beans.controle_sanitaire.TypeControleDTO;
import com.bmh.services.ITypeControleService;
import com.bmh.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TypeControleServiceImpl implements ITypeControleService {
	private final TypeControleSanitaireRepository repository;
	private Mapper mapper;

	@Autowired
	public TypeControleServiceImpl(TypeControleSanitaireRepository repository,Mapper mapper) {
		this.repository = repository;
		this.mapper=mapper;
	}

	@Override
	public TypeControleSanitaire add(TypeControleDTO typeControleDTO) {
		return mapper.map(repository.save(mapper.map(typeControleDTO, TypeControleSanitaire.class)),TypeControleSanitaire.class);
	}

	@Override
	public List<TypeControleDTO> getAll() {
		return mapper.mapList(repository.findAll(),TypeControleDTO.class);
	}

	@Override
	public TypeControleDTO getById(long id) {
		TypeControleSanitaire typeControleSanitaire=repository.findById(id).get();
		return mapper.map(typeControleSanitaire,TypeControleDTO.class);
	}

	@Override
	public void update(long id, TypeControleDTO typeControleDTO) {
		Optional<TypeControleSanitaire> typeControleSanitaire=repository.findById(id);
		if(typeControleSanitaire.isPresent()){
			TypeControleSanitaire exestingType=typeControleSanitaire.get();
			exestingType.setLibelle(typeControleDTO.getLibelle());
			exestingType.setDescription(typeControleDTO.getDescription());
			repository.save(exestingType);
		}
	}

	@Override
	public void delete(long id) {
		Optional<TypeControleSanitaire> typeControleSanitaire=repository.findById(id);
		if(typeControleSanitaire.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
