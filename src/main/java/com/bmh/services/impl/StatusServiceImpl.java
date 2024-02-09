package com.bmh.services.impl;

import com.bmh.Models.Status;
import com.bmh.Repositories.StatusRepository;
import com.bmh.beans.StatusDTO;
import com.bmh.services.IStatusService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements IStatusService {

	private final StatusRepository repository;

	private Mapper mapper;

	public StatusServiceImpl(StatusRepository repository,Mapper mapper) {
		this.repository = repository;
		this.mapper=mapper;
	}

	@Override
	public Status create(StatusDTO statusDTO) {
		return mapper.map(repository.save(mapper.map(statusDTO,Status.class)),Status.class);
	}

	@Override
	public List<StatusDTO> getAll() {
		return mapper.mapList(repository.findAll(),StatusDTO.class);
	}

	@Override
	public StatusDTO getById(long id) {
		Status status=repository.findById(id).get();
		return mapper.map(status,StatusDTO.class);
	}

	@Override
	public void delete(long id) {
		Optional<Status> status=repository.findById(id);
		if(status.isPresent()){
			repository.deleteById(id);
		}else{
			throw new EntityNotFoundException("Type avec l'ID"+id+"n'a pas trouvee");
		}
	}

	@Override
	public void update(long id, StatusDTO statusDTO) {
		Optional<Status> status=repository.findById(id);
		if(status.isPresent()){
			Status status1=status.get();
			status1.setLibelle(statusDTO.getLibelle());
			status1.setDescription(statusDTO.getDescription());
			repository.save(status1);
		}
	}
}
