package com.bmh.services.impl;

import com.bmh.Models.ProduitUtilise;
import com.bmh.Repositories.ProduitUtiliseRepository;
import com.bmh.beans.ProduitUtiliseDTO;
import com.bmh.services.IProduitUtiliseService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitUtiliseService implements IProduitUtiliseService {
	private final ProduitUtiliseRepository repository;
	private Mapper mapper;

	public ProduitUtiliseService(ProduitUtiliseRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ProduitUtilise add(ProduitUtiliseDTO produitUtiliseDTO) {
			return mapper.map(repository.save(mapper.map(produitUtiliseDTO,ProduitUtilise.class)),ProduitUtilise.class);
	}

	@Override
	public List<ProduitUtiliseDTO> getALl() {
		return mapper.mapList(repository.findAll(),ProduitUtiliseDTO.class);
	}

	@Override
	public ProduitUtiliseDTO getById(long id) {
		ProduitUtilise produitUtilise=repository.findById(id).get();
		return mapper.map(produitUtilise,ProduitUtiliseDTO.class);
	}

	@Override
	public void update(long id, ProduitUtiliseDTO produitUtiliseDTO) {
		Optional<ProduitUtilise> produitUtilise=repository.findById(id);
		if(produitUtilise.isPresent()){
			ProduitUtilise produitUtilise1=produitUtilise.get();
			produitUtilise1.setLibelle(produitUtiliseDTO.getLibelle());
			produitUtilise1.setDescription(produitUtiliseDTO.getDescription());
			repository.save(produitUtilise1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<ProduitUtilise> produitUtilise=repository.findById(id);
		if(produitUtilise.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
