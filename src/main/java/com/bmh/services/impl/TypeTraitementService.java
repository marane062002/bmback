package com.bmh.services.impl;

import com.bmh.Models.Animal;
import com.bmh.Models.TypeTraitement;
import com.bmh.Repositories.AnimalRepository;
import com.bmh.Repositories.TypeTraitementRepository;
import com.bmh.beans.AnimalDTO;
import com.bmh.beans.TypeTraitementDTO;
import com.bmh.services.IAnimalService;
import com.bmh.services.ITypeTraitementService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TypeTraitementService implements ITypeTraitementService {

	private final TypeTraitementRepository repository;
	private Mapper mapper;

	public TypeTraitementService(TypeTraitementRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TypeTraitement add(TypeTraitementDTO typeTraitementDTO) {
		return mapper.map(repository.save(mapper.map(typeTraitementDTO,TypeTraitement.class)),TypeTraitement.class);
	}

	@Override
	public List<TypeTraitementDTO> getALl() {
		return mapper.mapList(repository.findAll(),TypeTraitementDTO.class);
	}

	@Override
	public TypeTraitementDTO getById(long id) {
		TypeTraitement typeTraitement=repository.findById(id).get();
		return mapper.map(typeTraitement,TypeTraitementDTO.class);
	}

	@Override
	public void update(long id, TypeTraitementDTO typeTraitementDTO) {
		Optional<TypeTraitement> typeTraitement=repository.findById(id);
		if(typeTraitement.isPresent()){
			TypeTraitement typeTraitement1=typeTraitement.get();
			typeTraitement1.setLibelle(typeTraitementDTO.getLibelle());
			typeTraitement1.setDescription(typeTraitementDTO.getDescription());
			repository.save(typeTraitement1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<TypeTraitement> typeTraitement=repository.findById(id);
		if(typeTraitement.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}

    @Service
    public static class AnimalService implements IAnimalService {
        private final AnimalRepository repository;
        private Mapper mapper;

        public AnimalService(AnimalRepository repository, Mapper mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }

        @Override
        public Animal add(AnimalDTO animalDTO) {
            return mapper.map(repository.save(mapper.map(animalDTO,Animal.class)),Animal.class);
        }

        @Override
        public List<AnimalDTO> getALl() {
            return mapper.mapList(repository.findAll(),AnimalDTO.class);
        }

        @Override
        public AnimalDTO getById(long id) {
            Animal animal=repository.findById(id).get();
            return mapper.map(animal,AnimalDTO.class);
        }

        @Override
        public void update(long id, AnimalDTO animalDTO) {
            Optional<Animal> animalOptional=repository.findById(id);
            if(animalOptional.isPresent()){
                Animal animal=animalOptional.get();
                animal.setLibelle(animalDTO.getLibelle());
                animal.setDescription(animalDTO.getDescription());
                repository.save(animal);
            }
        }

        @Override
        public void delete(long id) {
            Optional<Animal> animal=repository.findById(id);
            if(animal.isPresent()){
                repository.deleteById(id);
            }else {
                throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
            }
        }
    }
}
