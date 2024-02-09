package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Models.medecinLegale.Origine;
import com.bmh.Repositories.medecinLegale.OrigineRepository;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.medecinLegale.OrigineDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.OrigineService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OrigineServiceImpl implements OrigineService {
	private final OrigineRepository repository;
	private final Mapper mapper;

	public OrigineServiceImpl(OrigineRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Origine add(OrigineDTO origineDTO) {
//		return mapper.map(repository.save(mapper.map(origineDTO, Origine.class)),Origine.class);
		Origine origine = repository.save(mapper.map(origineDTO, Origine.class));
		return origine;
	}

	@Override
	public List<OrigineDTO> getALl() {
		return mapper.mapList(repository.findAll(), OrigineDTO.class);
	}

	@Override
	public OrigineDTO getById(long id) {
		Origine origine=repository.findById(id).get();
		return mapper.map(origine,OrigineDTO.class);
	}

	@Override
	public void update(long id, OrigineDTO origineDTO) {
		Optional<Origine> origine=repository.findById(id);
		if(origine.isPresent()){
			Origine origine1=origine.get();
			origine1.setNom(origineDTO.getNom());
			origine1.setPrenom(origineDTO.getPrenom());
			origine1.setCin(origineDTO.getCin());
			origine1.setDate(origineDTO.getDate());
			origine1.setNumBulletin(origineDTO.getNumBulletin());
			origine1.setNationalite(origineDTO.getNationalite());
			repository.save(origine1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Origine> origine=repository.findById(id);
		if(origine.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
