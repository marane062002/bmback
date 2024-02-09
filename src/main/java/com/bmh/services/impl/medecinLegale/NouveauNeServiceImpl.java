package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.NouveauNe;
import com.bmh.Repositories.medecinLegale.NouveauNeRepository;
import com.bmh.beans.medecinLegale.NouveauNeDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.NouveauNeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NouveauNeServiceImpl implements NouveauNeService {
	private final NouveauNeRepository repository;
	private final Mapper mapper;

	public NouveauNeServiceImpl(NouveauNeRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public NouveauNe add(NouveauNeDTO nouveauNeDTO) {
		return mapper.map(repository.save(mapper.map(nouveauNeDTO, NouveauNe.class)),NouveauNe.class);
	}

	@Override
	public List<NouveauNeDTO> getALl() {
		return mapper.mapList(repository.findAll(), NouveauNeDTO.class);
	}

	@Override
	public NouveauNeDTO getById(long id) {
		NouveauNe nouveauNe=repository.findById(id).get();
		return mapper.map(nouveauNe,NouveauNeDTO.class);
	}

	@Override
	public void update(long id, NouveauNeDTO nouveauNeDTO) {
		Optional<NouveauNe> nouveauNe=repository.findById(id);
		if(nouveauNe.isPresent()){
			NouveauNe nouveauNe1=nouveauNe.get();
			nouveauNe1.setNom(nouveauNeDTO.getNom());
			nouveauNe1.setCinMere(nouveauNeDTO.getCinMere());
			nouveauNe1.setAdresseAccouchement(nouveauNeDTO.getAdresseAccouchement());
			nouveauNe1.setObservation(nouveauNeDTO.getObservation());
			nouveauNe1.setDateEnregistrement(nouveauNeDTO.getDateEnregistrement());
			nouveauNe1.setPoids(nouveauNeDTO.getPoids());
			nouveauNe1.setPrenom(nouveauNeDTO.getPrenom());
			nouveauNe1.setNomMere(nouveauNeDTO.getNomMere());
			nouveauNe1.setNationaliteMere(nouveauNeDTO.getNationaliteMere());
			nouveauNe1.setAdresseResMere(nouveauNeDTO.getAdresseResMere());
			nouveauNe1.setTelMere(nouveauNeDTO.getTelMere());
			nouveauNe1.setPrenomMere(nouveauNeDTO.getPrenomMere());
			nouveauNe1.setNatureAccouchement(nouveauNeDTO.getNatureAccouchement());
			nouveauNe1.setNumEnregistrement(nouveauNeDTO.getNumEnregistrement());
			nouveauNe1.setStatut(nouveauNeDTO.getStatut());
			nouveauNe1.setDateEnregistrement(nouveauNeDTO.getDateEnregistrement());
			nouveauNe1.setCinPere(nouveauNeDTO.getCinPere());
			nouveauNe1.setAdresseResPere(nouveauNeDTO.getAdresseResPere());
			nouveauNe1.setNomConstateur(nouveauNeDTO.getNomConstateur());
			nouveauNe1.setNomSageFemme(nouveauNeDTO.getNomSageFemme());
			nouveauNe1.setPrenomSageFemme(nouveauNeDTO.getPrenomSageFemme());
			nouveauNe1.setCinSageFemme(nouveauNeDTO.getCinSageFemme());
			nouveauNe1.setDateSageFemme(nouveauNeDTO.getDateSageFemme());
			nouveauNe1.setTelSageFemme(nouveauNeDTO.getTelSageFemme());
			nouveauNe1.setAdresseSageFemme(nouveauNeDTO.getAdresseSageFemme());
			nouveauNe1.setNomConstateur(nouveauNeDTO.getNomConstateur());
			nouveauNe1.setPrenomConstateur(nouveauNeDTO.getPrenomConstateur());
			nouveauNe1.setCinConstateur(nouveauNeDTO.getCinConstateur());
			nouveauNe1.setSexe(nouveauNeDTO.getSexe());
			repository.save(nouveauNe1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<NouveauNe> nouveauNe=repository.findById(id);
		if(nouveauNe.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}

	@Override
	public Page<NouveauNeDTO> AllPagination(Pageable pageable) {
		return repository.findAll(pageable).map(nouveauNe -> mapper.map(nouveauNe, NouveauNeDTO.class));
	}
}
