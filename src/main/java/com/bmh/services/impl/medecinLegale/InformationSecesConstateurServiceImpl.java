package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.Constateur;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.InformationSecesConstateur;
import com.bmh.Repositories.IConstateurRepository;
import com.bmh.Repositories.medecinLegale.InformationSecesConstateurRepository;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.InformationSecesConstateurDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.InformationSecesConstateurService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InformationSecesConstateurServiceImpl implements InformationSecesConstateurService {
	private final InformationSecesConstateurRepository repository;
	private final IConstateurRepository repositoryC;
	private final Mapper mapper;

	public InformationSecesConstateurServiceImpl(InformationSecesConstateurRepository repository, IConstateurRepository repositoryC, Mapper mapper) {
		this.repository = repository;
		this.repositoryC = repositoryC;
		this.mapper = mapper;
	}

	@Override
	public InformationSecesConstateur add(InformationSecesConstateurDTO informationSecesConstateurDTO) {
		Optional<Constateur> constateur=repositoryC.findById(informationSecesConstateurDTO.getConstateur().getId());
		if(constateur.isPresent()){
			InformationSecesConstateur informationSecesConstateur=mapper.map(informationSecesConstateurDTO, InformationSecesConstateur.class);
			informationSecesConstateur.setConstateur(constateur.get());
			return repository.save(informationSecesConstateur);
		}else {
			throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
		}
	}

	@Override
	public List<InformationSecesConstateurDTO> getALl() {
		return mapper.mapList(repository.findAll(),InformationSecesConstateurDTO.class);
	}

	@Override
	public InformationSecesConstateurDTO getById(long id) {
		InformationSecesConstateur informationSecesConstateur=repository.findById(id).get();
		return mapper.map(informationSecesConstateur, InformationSecesConstateurDTO.class);
	}

	@Override
	public void update(long id, InformationSecesConstateurDTO informationSecesConstateurDTO) {
		Optional<InformationSecesConstateur> informationSecesConstateur=repository.findById(id);
		if(informationSecesConstateur.isPresent()){
			InformationSecesConstateur informationSecesConstateur1=informationSecesConstateur.get();
			informationSecesConstateur1.setConstateur(informationSecesConstateurDTO.getConstateur());
			informationSecesConstateur1.setDateConstation(informationSecesConstateurDTO.getDateConstation());
			informationSecesConstateur1.setDateDeces(informationSecesConstateurDTO.getDateDeces());
			informationSecesConstateur1.setCausesDeces(informationSecesConstateurDTO.getCausesDeces());
			repository.save(informationSecesConstateur1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<InformationSecesConstateur> informationSecesConstateur=repository.findById(id);
		if(informationSecesConstateur.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
