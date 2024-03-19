package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.Prelevement;
import com.bmh.Models.medecinLegale.SageFemme;
import com.bmh.Repositories.StatusRepository;
import com.bmh.Repositories.medecinLegale.PrelevementRepository;
import com.bmh.beans.medecinLegale.PrelevementDTO;
import com.bmh.beans.medecinLegale.SageFemmeDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.PrelevementService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PrelevementServiceImpl implements PrelevementService {
	private final PrelevementRepository repository;
	private final StatusRepository statusRepository;
	private final Mapper mapper;

	public PrelevementServiceImpl(PrelevementRepository repository, StatusRepository statusRepository, Mapper mapper) {
		this.repository = repository;
		this.statusRepository = statusRepository;
		this.mapper = mapper;
	}

	@Override
	public Prelevement add(PrelevementDTO prelevementDTO) {
		try {
			Optional<Status> status = statusRepository.findById(prelevementDTO.getStatus().getId());
			if (status.isPresent() ) {
				Prelevement prelevement = mapper.map(prelevementDTO, Prelevement.class);
				prelevement.setStatus(prelevementDTO.getStatus());

				// Enregistrement de l'entité DecesNaturel dans la base de données
				return repository.save(prelevement);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
		}
	}

	@Override
	public List<Map<String, Object>> countPrelevementsBySexeAndAnalyseType() {
		return repository.countPrelevementsBySexeAndAnalyseType();
	}

	@Override
	public List<PrelevementDTO> getALl() {
		return mapper.mapList(repository.findAll(), PrelevementDTO.class);
	}

	@Override
	public List<PrelevementDTO> getByIdObstacle(long id) {
		return mapper.mapList(repository.findByObstacleDefuntsId(id), PrelevementDTO.class);
	}

	@Override
	public PrelevementDTO getById(long id) {
		Prelevement prelevement=repository.findById(id).get();
		return mapper.map(prelevement,PrelevementDTO.class);
	}

	@Override
	public void update(long id, PrelevementDTO prelevementDTO) {
		Optional<Prelevement> prelevement=repository.findById(id);
		if(prelevement.isPresent()){
			Prelevement prelevement1=prelevement.get();
			prelevement1.setStatus(prelevementDTO.getStatus());
			prelevement1.setDate(prelevementDTO.getDate());
			repository.save(prelevement1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Prelevement> prelevement=repository.findById(id);
		if(prelevement.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
