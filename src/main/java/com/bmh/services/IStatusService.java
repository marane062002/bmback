package com.bmh.services;

import com.bmh.Models.Status;
import com.bmh.beans.StatusDTO;

import java.util.List;

public interface IStatusService {
	Status create(StatusDTO statusDTO);
	List<StatusDTO> getAll();
	StatusDTO getById(long id);
	void delete(long id);
	void update(long id,StatusDTO statusDTO);
}
