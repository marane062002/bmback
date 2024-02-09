package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.InformationsDeclarants;
import com.bmh.Repositories.medecinLegale.InformationsDeclarantsRepository;
import com.bmh.beans.medecinLegale.InformationsDeclarantsDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.InformationsDeclarantsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InformationsDeclarantsServiceImpl implements InformationsDeclarantsService {

	private final InformationsDeclarantsRepository repository;
	private final Mapper mapper;

	public InformationsDeclarantsServiceImpl(InformationsDeclarantsRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public InformationsDeclarants add(InformationsDeclarantsDTO informationsDeclarantsDTO) {
		return mapper.map(repository.save(mapper.map(informationsDeclarantsDTO, InformationsDeclarants.class)),InformationsDeclarants.class);
	}

	@Override
	public List<InformationsDeclarantsDTO> getALl() {
		return mapper.mapList(repository.findAll(),InformationsDeclarantsDTO.class);
	}

	@Override
	public InformationsDeclarantsDTO getById(long id) {
		InformationsDeclarants informationsDeclarants=repository.findById(id).get();
		return mapper.map(informationsDeclarants,InformationsDeclarantsDTO.class);
	}

	@Override
	public void update(long id, InformationsDeclarantsDTO informationsDeclarantsDTO) {
		Optional<InformationsDeclarants> informationsDeclarants=repository.findById(id);
		if(informationsDeclarants.isPresent()){
			InformationsDeclarants informationsDeclarants1=informationsDeclarants.get();
			informationsDeclarants1.setNom(informationsDeclarantsDTO.getNom());
			informationsDeclarants1.setPrenom(informationsDeclarantsDTO.getPrenom());
			informationsDeclarants1.setQualite(informationsDeclarantsDTO.getQualite());
			informationsDeclarants1.setDate(informationsDeclarantsDTO.getDate());
			repository.save(informationsDeclarants1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<InformationsDeclarants> informationsDeclarants=repository.findById(id);
		if(informationsDeclarants.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
