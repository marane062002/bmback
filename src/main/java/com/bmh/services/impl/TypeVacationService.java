package com.bmh.services.impl;

import com.bmh.Models.TVacation;
import com.bmh.Repositories.TVaccationRepository;
import com.bmh.beans.TVacationDTO;
import com.bmh.services.ITVacationService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TypeVacationService implements ITVacationService {

	private final TVaccationRepository repository;
	private Mapper mapper;

	public TypeVacationService(TVaccationRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TVacation add(TVacationDTO tVacationDTO) {
		 return mapper.map(repository.save(mapper.map(tVacationDTO,TVacation.class)),TVacation.class);
	}

	@Override
	public List<TVacationDTO> getALl() {
		 return mapper.mapList(repository.findAll(),TVacationDTO.class);
	}

	@Override
	public TVacationDTO getById(long id) {
		 TVacation vacation=repository.findById(id).get();
		return mapper.map(vacation,TVacationDTO.class);
	}

	@Override
	public void update(long id, TVacationDTO tVacationDTO) {
		Optional<TVacation> vacation=repository.findById(id);
		if(vacation.isPresent()){
			TVacation vacation1=vacation.get();
			vacation1.setLibelle(tVacationDTO.getLibelle());
			vacation1.setDescription(tVacationDTO.getDescription());
			repository.save(vacation1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<TVacation> vacation=repository.findById(id);
		if(vacation.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
