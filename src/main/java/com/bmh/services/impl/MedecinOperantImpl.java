package com.bmh.services.impl;

import com.bmh.Models.MedecinOperant;
import com.bmh.Repositories.IMedecinOperantRepository;
import com.bmh.beans.MedecinOperantDTO;
import com.bmh.services.IMedecinOperantService;
import com.bmh.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class MedecinOperantImpl implements IMedecinOperantService {

	private final IMedecinOperantRepository repository;
	private Mapper mapper;

	@Autowired
	public MedecinOperantImpl(IMedecinOperantRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public MedecinOperant add(MedecinOperantDTO medecinOperantDTO) {
		return mapper.map(repository.save(mapper.map(medecinOperantDTO, MedecinOperant.class)), MedecinOperant.class);
	}

	@Override
	public List<MedecinOperantDTO> getAll() {
		return mapper.mapList(repository.findAll(), MedecinOperantDTO.class);
	}

	@Override
	public MedecinOperantDTO getById(long id) {
		MedecinOperant medecinOperant=repository.findById(id).get();
		return mapper.map(medecinOperant, MedecinOperantDTO.class);
	}

	@Override
	public void update(long id, MedecinOperantDTO medecinOperantDTO) {
		Optional<MedecinOperant> medecinOperantDTO1=repository.findById(id);
		if(medecinOperantDTO1.isPresent()){
			MedecinOperant medecin1=medecinOperantDTO1.get();
			medecin1.setLibelle(medecinOperantDTO.getLibelle());
			medecin1.setDescription(medecinOperantDTO.getDescription());
			repository.save(medecin1);
		}

	}

	@Override
	public void delete(long id) {
		Optional<MedecinOperant> medecinOperant=repository.findById(id);
		if(medecinOperant.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("Type avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
