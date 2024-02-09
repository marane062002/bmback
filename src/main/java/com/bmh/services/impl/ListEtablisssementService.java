package com.bmh.services.impl;

import com.bmh.Models.controle_sanitaire.ListEtablissement;
import com.bmh.Repositories.ListEtablissementRepository;
import com.bmh.beans.controle_sanitaire.ListEtablissementDTO;
import com.bmh.services.IListEtablissementService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ListEtablisssementService implements IListEtablissementService {
	private final ListEtablissementRepository repository;
	private Mapper mapper;

	public ListEtablisssementService(ListEtablissementRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ListEtablissement add(ListEtablissementDTO listEtablissementDTO) {
		return mapper.map(repository.save(mapper.map(listEtablissementDTO,ListEtablissement.class)),ListEtablissement.class);
	}

	@Override
	public List<ListEtablissementDTO> getAll() {
		return mapper.mapList(repository.findAll(),ListEtablissementDTO.class);
	}

	@Override
	public ListEtablissementDTO getById(long id) {
		ListEtablissement listEtablissement=repository.findById(id).get();
		return mapper.map(listEtablissement,ListEtablissementDTO.class);
	}

	@Override
	public void update(long id, ListEtablissementDTO listEtablissementDTO) {
		Optional<ListEtablissement> listEtablissement=repository.findById(id);
		if(listEtablissement.isPresent()){
			ListEtablissement listEtablissement1=listEtablissement.get();
			listEtablissement1.setLibelle(listEtablissementDTO.getLibelle());
			listEtablissement1.setDescription(listEtablissementDTO.getDescription());
			repository.save(listEtablissement1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<ListEtablissement> listEtablissement=repository.findById(id);
		if(listEtablissement.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
