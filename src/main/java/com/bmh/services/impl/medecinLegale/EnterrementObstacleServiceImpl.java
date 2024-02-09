package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.EntermentObstacle;
import com.bmh.Repositories.*;
import com.bmh.Repositories.medecinLegale.EnterrementObstacleRepository;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.EnterrementObstacleDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.EnterremementObstacleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EnterrementObstacleServiceImpl implements EnterremementObstacleService {
	private final EnterrementObstacleRepository repository;
	private final Mapper mapper;
	private final ArrondissementRepository arrondissementRepository;
	private final InterfaceRepository typeRepository;
	private final CommuneRepository communeRepository;
	private final QuartierRepository quartierRepository;

	public EnterrementObstacleServiceImpl(EnterrementObstacleRepository repository, Mapper mapper, ArrondissementRepository arrondissementRepository, InterfaceRepository typeRepository, CommuneRepository communeRepository, QuartierRepository quartierRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.arrondissementRepository = arrondissementRepository;
		this.typeRepository = typeRepository;
		this.communeRepository = communeRepository;
		this.quartierRepository = quartierRepository;
	}

	@Override
	public EntermentObstacle add(EnterrementObstacleDTO enterrementObstacleDTO) {
		try {
			Optional<Type> type = typeRepository.findById(enterrementObstacleDTO.getType().getId());
			Optional<Quartier> quartier = quartierRepository.findById(enterrementObstacleDTO.getQuartier().getId());
			Optional<Commune> commune=communeRepository.findById(enterrementObstacleDTO.getCommune().getId());
			Optional<Arrondissement> arrondissement=arrondissementRepository.findById(enterrementObstacleDTO.getArrondissement().getId());
			if (type.isPresent() && quartier.isPresent() && commune.isPresent() && arrondissement.isPresent()) {
				EntermentObstacle entermentObstacle = mapper.map(enterrementObstacleDTO, EntermentObstacle.class);
				entermentObstacle.setType(type.get());
				entermentObstacle.setQuartier(quartier.get());
				entermentObstacle.setCommune(commune.get());
				entermentObstacle.setArrondissement(arrondissement.get());

				// Enregistrement de l'entité DecesNaturel dans la base de données
				return repository.save(entermentObstacle);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
		}
	}


	@Override
	public List<EnterrementObstacleDTO> getALl() {
		return mapper.mapList(repository.findAll(), EnterrementObstacleDTO.class);
	}

	@Override
	public EnterrementObstacleDTO getById(long id) {
		EntermentObstacle entermentObstacle = repository.findById(id).get();
		return mapper.map(entermentObstacle, EnterrementObstacleDTO.class);
	}

	@Override
	public void update(long id, EnterrementObstacleDTO enterrementObstacleDTO) {
		Optional<EntermentObstacle> entermentObstacle = repository.findById(id);
		if (entermentObstacle.isPresent()) {
			EntermentObstacle entermentObstacle1 = entermentObstacle.get();
			entermentObstacle1.setType(enterrementObstacleDTO.getType());
			entermentObstacle1.setSexe(enterrementObstacleDTO.getSexe());
			entermentObstacle1.setCommune(enterrementObstacleDTO.getCommune());
			entermentObstacle1.setArrondissement(enterrementObstacleDTO.getArrondissement());
			entermentObstacle1.setQuartier(enterrementObstacleDTO.getQuartier());
			entermentObstacle1.setDateEnterementObstacle(enterrementObstacleDTO.getDateEnterementObstacle());
			entermentObstacle1.setLieuEnterementObstacle(enterrementObstacleDTO.getLieuEnterementObstacle());
			entermentObstacle1.setLieuRecuperationObstacle(enterrementObstacleDTO.getLieuRecuperationObstacle());
			repository.save(entermentObstacle1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<EntermentObstacle> entermentObstacleOptional=repository.findById(id);
		if(entermentObstacleOptional.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}


}
