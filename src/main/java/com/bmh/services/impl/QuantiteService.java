package com.bmh.services.impl;

import com.bmh.Models.Quantite;
import com.bmh.Repositories.QuantiteRepository;
import com.bmh.beans.QuantiteDTO;
import com.bmh.services.IQuantiteService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class QuantiteService implements IQuantiteService {
	private final QuantiteRepository repository;
	private Mapper mapper;

	public QuantiteService(QuantiteRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Quantite add(QuantiteDTO quantiteDTO) {
		return mapper.map(repository.save(mapper.map(quantiteDTO,Quantite.class)),Quantite.class);
	}

	@Override
	public List<QuantiteDTO> getALl() {
		return mapper.mapList(repository.findAll(),QuantiteDTO.class);
	}

	@Override
	public QuantiteDTO getById(long id) {
		Quantite quantite=repository.findById(id).get();
		return mapper.map(quantite,QuantiteDTO.class);
	}

	@Override
	public void update(long id, QuantiteDTO quantiteDTO) {
		Optional<Quantite> quantite=repository.findById(id);
		if(quantite.isPresent()){
			Quantite quantite1=quantite.get();
			quantite1.setLibelle(quantiteDTO.getLibelle());
			quantite1.setDescription(quantiteDTO.getDescription());
			repository.save(quantite1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Quantite> quantite=repository.findById(id);
		if(quantite.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
