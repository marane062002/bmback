package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.MedecinOperant;
import com.bmh.Models.Status;
import com.bmh.Models.medecinLegale.Autopsie;
import com.bmh.Models.medecinLegale.Prelevement;
import com.bmh.Models.medecinLegale.SageFemme;
import com.bmh.Repositories.IMedecinOperantRepository;
import com.bmh.Repositories.StatusRepository;
import com.bmh.Repositories.medecinLegale.AutopsieRepository;
import com.bmh.beans.medecinLegale.AutopsieDTO;
import com.bmh.beans.medecinLegale.PrelevementDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.AutopsieService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AutopsieServiceImpl implements AutopsieService {
	private final AutopsieRepository repository;
	private final IMedecinOperantRepository medecinOperantRepository;
	private final StatusRepository statusRepository;
	private final Mapper mapper;

	public AutopsieServiceImpl(AutopsieRepository repository, IMedecinOperantRepository medecinOperantRepository, StatusRepository statusRepository, Mapper mapper) {
		this.repository = repository;
		this.medecinOperantRepository = medecinOperantRepository;
		this.statusRepository = statusRepository;
		this.mapper = mapper;
	}

	@Override
	public Autopsie add(AutopsieDTO autopsieDTO) {
		try {
			Optional<Status> status = statusRepository.findById(autopsieDTO.getStatus().getId());
			Optional<MedecinOperant> medecinOperant = medecinOperantRepository.findById(autopsieDTO.getMedecinOperant().getId());
			if (status.isPresent() && medecinOperant.isPresent() ) {
				Autopsie autopsie = mapper.map(autopsieDTO, Autopsie.class);
				autopsie.setStatus(autopsieDTO.getStatus());
				autopsie.setMedecinOperant(autopsieDTO.getMedecinOperant());
				// Enregistrement de l'entité DecesNaturel dans la base de données
				return repository.save(autopsie);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
		}
	}

	@Override
	public List<AutopsieDTO> getALl() {
		return mapper.mapList(repository.findAll(),AutopsieDTO.class);
	}

	@Override
	public AutopsieDTO getById(long id) {
		Autopsie autopsie=repository.findById(id).get();
		return mapper.map(autopsie, AutopsieDTO.class);
	}

	@Override
	public void update(long id, AutopsieDTO autopsieDTO) {
		Optional<Autopsie> autopsie=repository.findById(id);
		if(autopsie.isPresent()){
			Autopsie autopsie1=autopsie.get();
			autopsie1.setMedecinOperant(autopsieDTO.getMedecinOperant());
			autopsie1.setStatus(autopsieDTO.getStatus());
			autopsie1.setDate(autopsieDTO.getDate());
			repository.save(autopsie1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Autopsie> autopsie=repository.findById(id);
		if(autopsie.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
