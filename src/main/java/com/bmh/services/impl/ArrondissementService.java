package com.bmh.services.impl;

import com.bmh.Models.Arrondissement;
import com.bmh.Repositories.ArrondissementRepository;
import com.bmh.beans.ArrondissementDTO;
import com.bmh.services.IArrondissementService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ArrondissementService implements IArrondissementService {

	private final ArrondissementRepository repository;
	private Mapper mapper;

	public ArrondissementService(ArrondissementRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Arrondissement add(ArrondissementDTO arrondissementDTO) {
		return mapper.map(repository.save(mapper.map(arrondissementDTO,Arrondissement.class)),Arrondissement.class);
	}

	@Override
	public List<ArrondissementDTO> getALl() {
		return mapper.mapList(repository.findAll(),ArrondissementDTO.class);
	}

	@Override
	public ArrondissementDTO getById(long id) {
		Arrondissement arrondissement=repository.findById(id).get();
		return mapper.map(arrondissement,ArrondissementDTO.class);
	}

	@Override
	public void update(long id, ArrondissementDTO arrondissementDTO) {
		Optional<Arrondissement> arrondissement=repository.findById(id);
		if(arrondissement.isPresent()){
			Arrondissement arrondissement1=arrondissement.get();
			arrondissement1.setLibelle(arrondissementDTO.getLibelle());
			arrondissement1.setDescription(arrondissementDTO.getDescription());
			repository.save(arrondissement1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Arrondissement> arrondissement=repository.findById(id);
		if(arrondissement.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
