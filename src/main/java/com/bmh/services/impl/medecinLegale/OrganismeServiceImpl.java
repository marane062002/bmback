package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.Type;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.Organisme;
import com.bmh.Repositories.InterfaceRepository;
import com.bmh.Repositories.medecinLegale.OrganismeRepository;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.OrganismeDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.OrganismeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OrganismeServiceImpl implements OrganismeService {

	private final OrganismeRepository repository;
	private final InterfaceRepository typeRepository;
	private final Mapper mapper;

	public OrganismeServiceImpl(OrganismeRepository repository, InterfaceRepository typeRepository, Mapper mapper) {
		this.repository = repository;
		this.typeRepository = typeRepository;
		this.mapper = mapper;
	}

	@Override
	public Organisme add(OrganismeDTO organismeDTO) {
		try{
			Optional<Type> type=typeRepository.findById(organismeDTO.getType().getId());
			if(type.isPresent()){
				Organisme organisme = mapper.map(organismeDTO, Organisme.class);
				organisme.setType(type.get());
				return repository.save(organisme);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
		}
	}



	@Override
	public List<OrganismeDTO> getALl() {
		return mapper.mapList(repository.findAll(), OrganismeDTO.class);
	}

	@Override
	public OrganismeDTO getById(long id) {
		Organisme organisme=repository.findById(id).get();
		return mapper.map(organisme,OrganismeDTO.class);
	}

	@Override
	public void update(long id, OrganismeDTO organismeDTO) {
		Optional<Organisme> organisme=repository.findById(id);
		if(organisme.isPresent()){
			Organisme organisme1=organisme.get();
			organisme1.setRc(organismeDTO.getRc());
			organisme1.setIFf(organismeDTO.getIFf());
			organisme1.setIce(organismeDTO.getIce());
			organisme1.setAdresse(organismeDTO.getAdresse());
			organisme1.setTel(organismeDTO.getTel());
			organisme1.setRaisonSociale(organismeDTO.getRaisonSociale());
			organisme1.setType(organismeDTO.getType());
			repository.save(organisme1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Organisme> organisme=repository.findById(id);
		if(organisme.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}

	@Override
	public Page<OrganismeDTO> AllPagination(Pageable pageable) {
		return repository.findAll(pageable).map(organisme -> mapper.map(organisme, OrganismeDTO.class));
	}
}
