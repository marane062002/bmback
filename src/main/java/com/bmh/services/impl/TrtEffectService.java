package com.bmh.services.impl;

import com.bmh.Models.TraitEffect;
import com.bmh.Repositories.TrtEffectRepository;
import com.bmh.beans.TraitEffectDTO;
import com.bmh.services.ITraitEffectService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TrtEffectService implements ITraitEffectService {

	private final TrtEffectRepository repository;
	private Mapper mapper;

	public TrtEffectService(TrtEffectRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TraitEffect add(TraitEffectDTO traitEffectDTO) {
		return mapper.map(repository.save(mapper.map(traitEffectDTO,TraitEffect.class)),TraitEffect.class);
	}

	@Override
	public List<TraitEffectDTO> getALl() {
		return mapper.mapList(repository.findAll(),TraitEffectDTO.class);
	}

	@Override
	public TraitEffectDTO getById(long id) {
		TraitEffect traitEffect=repository.findById(id).get();
		return mapper.map(traitEffect,TraitEffectDTO.class);
	}

	@Override
	public void update(long id, TraitEffectDTO traitEffectDTO) {
		Optional<TraitEffect> trtEfft=repository.findById(id);
		if(trtEfft.isPresent()){
			TraitEffect traitEffect=trtEfft.get();
			traitEffect.setLibelle(traitEffectDTO.getLibelle());
			traitEffect.setDescription(traitEffectDTO.getDescription());
			repository.save(traitEffect);
		}
	}

	@Override
	public void delete(long id) {
		Optional<TraitEffect> traitEffect=repository.findById(id);
		if(traitEffect.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
