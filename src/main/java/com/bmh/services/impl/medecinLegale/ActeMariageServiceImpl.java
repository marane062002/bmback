package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.ActeMariage;
import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Repositories.medecinLegale.ActeMariageRepository;
import com.bmh.beans.medecinLegale.ActeMariageDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.ActeMariageService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ActeMariageServiceImpl implements ActeMariageService {
	private final ActeMariageRepository repository;
	private Mapper mapper;

	public ActeMariageServiceImpl(ActeMariageRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ActeMariage add(ActeMariageDTO acteMariageDTO) {
		return mapper.map(repository.save(mapper.map(acteMariageDTO, ActeMariage.class)),ActeMariage.class);
	}

	@Override
	public List<ActeMariageDTO> getALl() {
		return mapper.mapList(repository.findAll(),ActeMariageDTO.class);
	}

	@Override
	public ActeMariageDTO getById(long id) {
		ActeMariage acteMariage=repository.findById(id).get();
		return mapper.map(acteMariage,ActeMariageDTO.class);
	}

	@Override
	public void update(long id, ActeMariageDTO acteMariageDTO) {
		Optional<ActeMariage> acteMariage=repository.findById(id);
		if(acteMariage.isPresent()){
			ActeMariage acteMariage1=acteMariage.get();
			acteMariage1.setNomPere(acteMariageDTO.getNomPere());
			acteMariage1.setPrenomPere(acteMariageDTO.getPrenomPere());
			acteMariage1.setCinPere(acteMariageDTO.getCinPere());
			acteMariage1.setNationalitePere(acteMariageDTO.getNationalitePere());
			acteMariage1.setAdresseResPere(acteMariageDTO.getAdresseResPere());
			acteMariage1.setStatut(acteMariageDTO.getStatut());
			acteMariage1.setTelPere(acteMariageDTO.getTelPere());
			acteMariage1.setCinPere(acteMariageDTO.getCinPere());
			repository.save(acteMariage1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<ActeMariage> acteMariage=repository.findById(id);
		if(acteMariage.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
