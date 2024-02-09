package com.bmh.services.impl;

import com.bmh.Models.Commune;
import com.bmh.Repositories.CommuneRepository;
import com.bmh.beans.CommuneDTO;
import com.bmh.services.ICommuneService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CommuneService implements ICommuneService {
	private final CommuneRepository repository;
	private Mapper mapper;

	public CommuneService(CommuneRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Commune add(CommuneDTO communeDTO) {
		return mapper.map(repository.save(mapper.map(communeDTO,Commune.class)),Commune.class);
	}

	@Override
	public List<CommuneDTO> getALl() {
		return mapper.mapList(repository.findAll(),CommuneDTO.class);
	}

	@Override
	public CommuneDTO getById(long id) {
		Commune commune=repository.findById(id).get();
		return mapper.map(commune,CommuneDTO.class);
	}

	@Override
	public void update(long id, CommuneDTO communeDTO) {
		Optional<Commune> commune=repository.findById(id);
		if(commune.isPresent()){
			Commune commune1=commune.get();
			commune1.setLibelle(communeDTO.getLibelle());
			commune1.setDescription(communeDTO.getDescription());
			repository.save(commune1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Commune> commune=repository.findById(id);
		if(commune.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
