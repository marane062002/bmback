package com.bmh.services.impl;

import com.bmh.Models.Quartier;
import com.bmh.Repositories.QuartierRepository;
import com.bmh.beans.QuantiteDTO;
import com.bmh.beans.QuartierDTO;
import com.bmh.services.IQuartierService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class QuartierService implements IQuartierService {
	private final QuartierRepository repository;
	private Mapper mapper;

	public QuartierService(QuartierRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Quartier add(QuartierDTO quartierDTO) {
		return mapper.map(repository.save(mapper.map(quartierDTO,Quartier.class)),Quartier.class);
	}

	@Override
	public List<QuartierDTO> getALl() {
		return mapper.mapList(repository.findAll(),QuartierDTO.class);
	}

	@Override
	public QuartierDTO getById(long id) {
		Quartier quartier=repository.findById(id).get();
		return mapper.map(quartier,QuartierDTO.class);
	}

	@Override
	public void update(long id, QuartierDTO quartierDTO) {
		Optional<Quartier> quartier=repository.findById(id);
		if(quartier.isPresent()){
			Quartier quartier1=quartier.get();
			quartier1.setLibelle(quartierDTO.getLibelle());
			quartier1.setDescription(quartierDTO.getDescription());
			repository.save(quartier1);
		}

	}


	@Override
	public void delete(long id) {
		Optional<Quartier> quartier=repository.findById(id);
		if(quartier.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
