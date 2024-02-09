package com.bmh.services.impl;

import com.bmh.Models.TDeclaration;
import com.bmh.Repositories.TDeclarationRepository;
import com.bmh.beans.TDeclarationDTO;
import com.bmh.services.ITDeclarationService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TDeclarationService implements ITDeclarationService {

	private final TDeclarationRepository repository;
	private Mapper mapper;

	public TDeclarationService(TDeclarationRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TDeclaration add(TDeclarationDTO tDeclarationDTO) {
		return mapper.map(repository.save(mapper.map(tDeclarationDTO,TDeclaration.class)),TDeclaration.class);
	}

	@Override
	public List<TDeclarationDTO> getALl() {
		return mapper.mapList(repository.findAll(),TDeclarationDTO.class);
	}

	@Override
	public TDeclarationDTO getById(long id) {
		TDeclaration declaration=repository.findById(id).get();
		return mapper.map(declaration,TDeclarationDTO.class);
	}

	@Override
	public void update(long id, TDeclarationDTO tDeclarationDTO) {
		Optional<TDeclaration> declaration=repository.findById(id);
		if(declaration.isPresent()){
			TDeclaration declaration1=declaration.get();
			declaration1.setLibelle(tDeclarationDTO.getLibelle());
			declaration1.setDescription(tDeclarationDTO.getDescription());
			repository.save(declaration1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<TDeclaration> declaration=repository.findById(id);
		if(declaration.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
