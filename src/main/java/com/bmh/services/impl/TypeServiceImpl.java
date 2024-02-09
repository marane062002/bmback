package com.bmh.services.impl;

import com.bmh.Models.Type;
import com.bmh.Repositories.InterfaceRepository;
import com.bmh.beans.MedecinOperantDTO;
import com.bmh.beans.TypeCriteria;
import com.bmh.beans.TypeDto;
import com.bmh.services.InterfaceService;
import com.bmh.services.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements InterfaceService<TypeDto> {

    private final InterfaceRepository repository;
	private final Mapper mapper;

    @Autowired
    public TypeServiceImpl(InterfaceRepository repository, Mapper mapper) {
        this.repository = repository;
		this.mapper = mapper;
	}


    ModelMapper modelMapper = new ModelMapper();
    @Override
    public void add(TypeDto typeDto) {
        try{
            Type type1=createTypeFromDTO(typeDto);
            repository.save(type1);
        }catch(DataIntegrityViolationException EX){
            EX.printStackTrace();
            throw  new RuntimeException("Error lors de l'ajout de la maladie.",EX);
        }

    }

    @Override
    public void update(TypeDto typeDto, long id) {
        Optional<Type> type1=repository.findById(id);
        if(type1.isPresent()){
            Type exestingType=type1.get();
            exestingType.setLibelle(typeDto.getLibelle());
            exestingType.setDescription(typeDto.getDescription());
            repository.save(exestingType);
        }

    }

    @Override
    public void delete(long id) {
        Optional<Type> typeOptional=repository.findById(id);
        if(typeOptional.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Type avec l'ID"+id+"n'a pas trouvee");
        }
    }



  /*  @Override
    public List<TypeDto> getAll() {
        List<Type> types = repository.findAll();

        // Convert Type entities to TypeDto using convertTypeFromDto method
        return types.stream()
                .map(type->modelMapper.map(type,TypeDto.class))
                .collect(Collectors.toList());
    }*/

	@Override
    public List<TypeDto> getAll(){
		 return mapper.mapList(repository.findAll(), TypeDto.class);
    }


    @Override
    public TypeDto getById(long id) {
		Type type=repository.findById(id).get();
		System.out.println("jjjjjjjjjjj"+type);
		return mapper.map(type,TypeDto.class);

    }



	/*@Override
	public Page<Type> getTypeByLibelleAndDescription(long id) {
		try {
			return repository.findById(id);
		} catch (Exception e) {
			throw new RuntimeException("Unable to fetch types", e);
		}
	}*/


	public Type createTypeFromDTO(TypeDto typeDto) {
        Type type = new Type();
        type.setLibelle(typeDto.getLibelle());
        type.setDescription(typeDto.getDescription());
        // Optionally set other properties

        return type;
    }

	/*public List<Type> searchTypes(String keyword) {
		return repository.findByLibelleContaining(keyword);
	}*/



}
