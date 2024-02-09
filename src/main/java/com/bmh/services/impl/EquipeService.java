package com.bmh.services.impl;

import com.bmh.Models.Equipe;
import com.bmh.Repositories.EquipeRepository;
import com.bmh.beans.EquipeDTO;
import com.bmh.services.IEquipeService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeService implements IEquipeService {

	private final EquipeRepository repository;
	private Mapper mapper;

	public EquipeService(EquipeRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Equipe add(EquipeDTO equipeDTO) {
		return mapper.map(repository.save(mapper.map(equipeDTO,Equipe.class)),Equipe.class);
	}

	@Override
	public List<EquipeDTO> getALl() {
		return mapper.mapList(repository.findAll(),EquipeDTO.class);
	}

	@Override
	public EquipeDTO getById(long id) {
		Equipe equipe=repository.findById(id).get();
		return mapper.map(equipe,EquipeDTO.class);
	}

	@Override
	public void update(long id, EquipeDTO equipeDTO) {
		Optional<Equipe> equipe=repository.findById(id);
		if(equipe.isPresent()){
			Equipe equipe1=equipe.get();
			equipe1.setNom(equipeDTO.getNom());
			equipe1.setPrenom(equipeDTO.getPrenom());
			equipe1.setCin(equipeDTO.getCin());
			equipe1.setTel(equipeDTO.getTel());
			repository.save(equipe1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Equipe> equipe=repository.findById(id);
		if(equipe.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
