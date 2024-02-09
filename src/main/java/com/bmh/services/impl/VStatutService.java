package com.bmh.services.impl;

import com.bmh.Models.VctStatut;
import com.bmh.Repositories.VStatutRepository;
import com.bmh.beans.VStatutDTO;
import com.bmh.services.IVStatutService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class VStatutService implements IVStatutService {
	private final VStatutRepository repository;
	private Mapper mapper;

	public VStatutService(VStatutRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public VctStatut add(VStatutDTO vStatutDTO) {
		return mapper.map(repository.save(mapper.map(vStatutDTO,VctStatut.class)),VctStatut.class);
	}

	@Override
	public List<VStatutDTO> getALl() {
			return mapper.mapList(repository.findAll(),VStatutDTO.class);
	}

	@Override
	public VStatutDTO getById(long id) {
		VctStatut vctStatut=repository.findById(id).get();
		return mapper.map(vctStatut,VStatutDTO.class);
	}

	@Override
	public void update(long id, VStatutDTO vStatutDTO) {
		Optional<VctStatut> vctStatut=repository.findById(id);
		if(vctStatut.isPresent()){
			VctStatut vctStatut1=vctStatut.get();
			vctStatut1.setLibelle(vStatutDTO.getLibelle());
			vctStatut1.setDescription(vStatutDTO.getDescription());
			repository.save(vctStatut1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<VctStatut> vctStatut=repository.findById(id);
		if(vctStatut.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
