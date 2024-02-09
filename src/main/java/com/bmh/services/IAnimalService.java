package com.bmh.services;

import com.bmh.Models.Animal;
import com.bmh.beans.AnimalDTO;

import java.util.List;

public interface IAnimalService {
	Animal add(AnimalDTO animalDTO);
	List<AnimalDTO> getALl();
	AnimalDTO getById(long id);
	void update(long id,AnimalDTO animalDTO);
	void delete(long id);
}
