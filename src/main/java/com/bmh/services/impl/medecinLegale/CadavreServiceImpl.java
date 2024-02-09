package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.Conducteur;
import com.bmh.Models.medecinLegale.Cadavre;
import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Repositories.ConducteurRepository;
import com.bmh.Repositories.medecinLegale.CadavreRepository;
import com.bmh.Repositories.medecinLegale.FourgonRepository;
import com.bmh.beans.medecinLegale.CadavreDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.CadavreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CadavreServiceImpl implements CadavreService {

	private final CadavreRepository repository;
	private final FourgonRepository fourgonRepository;
	private final ConducteurRepository conducteurRepository;
	private Mapper mapper;

	public CadavreServiceImpl(CadavreRepository repository, FourgonRepository fourgonRepository, ConducteurRepository conducteurRepository, Mapper mapper) {
		this.repository = repository;
		this.fourgonRepository = fourgonRepository;
		this.conducteurRepository = conducteurRepository;
		this.mapper = mapper;
	}

	@Override
	public Cadavre add(CadavreDTO cadavreDTO) {
		Optional<Fourgon> fourgon=fourgonRepository.findById(cadavreDTO.getFourgon().getId());
		Optional<Conducteur> conducteur=conducteurRepository.findById(cadavreDTO.getConducteur().getId());
		if(fourgon.isPresent()){
			Cadavre cadavre=mapper.map(cadavreDTO,Cadavre.class);
			cadavre.setFourgon(fourgon.get());
			cadavre.setConducteur(conducteur.get());
			return repository.save(cadavre);
		}
		return mapper.map(repository.save(mapper.map(cadavreDTO, Cadavre.class)),Cadavre.class);
	}

	@Override
	public List<CadavreDTO> getALl() {
		return mapper.mapList(repository.findAll(), CadavreDTO.class);
	}

	@Override
	public CadavreDTO getById(long id) {
		Cadavre cadavre=repository.findById(id).get();
		return mapper.map(cadavre,CadavreDTO.class);
	}

	@Override
	public void update(long id, CadavreDTO cadavreDTO) {
		Optional<Cadavre> cadavre=repository.findById(id);
		if(cadavre.isPresent()){
			Cadavre cadavre1=cadavre.get();
			cadavre1.setDate(cadavreDTO.getDate());
			cadavre1.setObservation(cadavreDTO.getObservation());
			cadavre1.setAutorizationProcureur(cadavreDTO.getAutorizationProcureur());
			cadavre1.setStatut(cadavreDTO.getObservation());
			repository.save(cadavre1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Cadavre> cadavre=repository.findById(id);
		if(cadavre.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
