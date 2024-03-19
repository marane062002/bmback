package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.Models.medecinLegale.Examen;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.Repositories.IMedecinOperantRepository;
import com.bmh.Repositories.ITypeExamenRepository;
import com.bmh.Repositories.StatusRepository;
import com.bmh.Repositories.medecinLegale.ExamenRepository;
import com.bmh.Repositories.medecinLegale.ObstacleDefuntsRepository;
import com.bmh.beans.medecinLegale.EntrementInhumationDTO;
import com.bmh.beans.medecinLegale.ExamenDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.ExamenService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService {
	private final ExamenRepository repository;
	private final ITypeExamenRepository typeExamenRepository;
	private final IMedecinOperantRepository medecinOperantRepository;
	private final StatusRepository statusRepository;
//	private final ObstacleDefunts obstacleDefunts;
	private final Mapper mapper;
	private final ObstacleDefuntsRepository obstacleDefuntsRepository;

	public ExamenServiceImpl(ExamenRepository repository, ITypeExamenRepository typeExamenRepository, IMedecinOperantRepository medecinOperantRepository, StatusRepository statusRepository, Mapper mapper,
							 ObstacleDefuntsRepository obstacleDefuntsRepository) {
		this.repository = repository;
		this.typeExamenRepository = typeExamenRepository;
		this.medecinOperantRepository = medecinOperantRepository;
		this.statusRepository = statusRepository;

		this.mapper = mapper;
		this.obstacleDefuntsRepository = obstacleDefuntsRepository;
	}

	@Override
	public List<Map<String, Object>> getExamenStatistics() {
		return repository.countBySexe();
	}

	@Override
	public Examen add(ExamenDTO examenDTO) {
		try {
			Optional<TypeExamen> typeExamen = typeExamenRepository.findById(examenDTO.getTypeExamen().getId());
			Optional<MedecinOperant> medecinOperant=medecinOperantRepository.findById(examenDTO.getMedecinOperant().getId());
			Optional<Status> status=statusRepository.findById(examenDTO.getStatus().getId());
			Optional<ObstacleDefunts> obstacleDefunts=obstacleDefuntsRepository.findById(examenDTO.getObstacleDefunts().getId());
			if (typeExamen.isPresent() && medecinOperant.isPresent() && status.isPresent()) {
				Examen examen = mapper.map(examenDTO, Examen.class);
				examen.setTypeExamen(typeExamen.get());
				examen.setMedecinOperant(medecinOperant.get());
				examen.setStatus(status.get());
                examen.setObstacleDefunts(obstacleDefunts.get());
				// Enregistrement de l'entité DecesNaturel dans la base de données
				return repository.save(examen);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
		}
	}

	@Override
	public List<ExamenDTO> getALl() {
		return mapper.mapList(repository.findAll(), ExamenDTO.class);
	}

	@Override
	public List<ExamenDTO> getByIdObstacle(long id) {
		return mapper.mapList(repository.findByObstacleDefuntsId(id), ExamenDTO.class);
	}


	@Override
	public ExamenDTO getById(long id) {
		Examen examen=repository.findById(id).get();
		return mapper.map(examen,ExamenDTO.class);
	}

	@Override
	public void update(long id, ExamenDTO examenDTO) {
		Optional<Examen> examen=repository.findById(id);
		if(examen.isPresent()){
			Examen examen1=examen.get();
			examen1.setTypeExamen(examenDTO.getTypeExamen());
			examen1.setMedecinOperant(examenDTO.getMedecinOperant());
			examen1.setStatus(examenDTO.getStatus());
			examen1.setDate(examenDTO.getDate());
			repository.save(examen1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Examen> examen=repository.findById(id);
		if(examen.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
