package com.bmh.services.impl;

import com.bmh.Models.ObjetSortie;
import com.bmh.Repositories.ObjetSortieRepository;
import com.bmh.beans.ObjetSortieDTO;
import com.bmh.services.IObjetSortieService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ObjetSortieService implements IObjetSortieService {
	private final ObjetSortieRepository repository;
	private Mapper mapper;

	public ObjetSortieService(ObjetSortieRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ObjetSortie add(ObjetSortieDTO objetSortieDTO) {
		return mapper.map(repository.save(mapper.map(objetSortieDTO,ObjetSortie.class)),ObjetSortie.class);
	}

	@Override
	public List<ObjetSortieDTO> getALl() {
		return mapper.mapList(repository.findAll(),ObjetSortieDTO.class);
	}

	@Override
	public ObjetSortieDTO getById(long id) {
		ObjetSortie objetSortie=repository.findById(id).get();
		return mapper.map(objetSortie,ObjetSortieDTO.class);
	}

	@Override
	public void update(long id, ObjetSortieDTO objetSortieDTO) {
		Optional<ObjetSortie> objetSortie=repository.findById(id);
		if(objetSortie.isPresent()){
			ObjetSortie objetSortie1=objetSortie.get();
			objetSortie1.setLibelle(objetSortieDTO.getLibelle());
			objetSortie1.setDescription(objetSortieDTO.getDescription());
			repository.save(objetSortie1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<ObjetSortie> objetSortie=repository.findById(id);
		if(objetSortie.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
