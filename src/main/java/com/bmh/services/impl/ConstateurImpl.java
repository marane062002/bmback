package com.bmh.services.impl;

import com.bmh.Models.Constateur;
import com.bmh.Models.Type;
import com.bmh.Repositories.IConstateurRepository;
import com.bmh.beans.ConstateurDTO;
import com.bmh.beans.TypeDto;
import com.bmh.beans.constateur1DTO;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class ConstateurImpl implements IConstateurService{
	private final IConstateurRepository repository;
	private final Mapper mapper;

	public ConstateurImpl(IConstateurRepository repository, Mapper mapper) {
		this.repository = repository;

		this.mapper = mapper;
	}


	@Override
	public Constateur add(ConstateurDTO constateurDTO) {
		return mapper.map(repository.save(mapper.map(constateurDTO,Constateur.class)),Constateur.class);
	}

	@Override
	public void update(ConstateurDTO constateurDTO, long id) {
		Optional<Constateur> const1=repository.findById(id);
		if(const1.isPresent()){
			Constateur exestingConst=const1.get();
			exestingConst.setNom(constateurDTO.getNom());
			exestingConst.setPrenom(constateurDTO.getPrenom());
			exestingConst.setCin(constateurDTO.getCin());
			exestingConst.setTel(constateurDTO.getTel());
			repository.save(exestingConst);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Constateur> constOptional=repository.findById(id);
		if(constOptional.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("Type avec l'ID"+id+"n'a pas trouvee");
		}
	}

	@Override
	public List<ConstateurDTO> getAll() {
		return mapper.mapList(repository.findAll(), ConstateurDTO.class);
	}

	@Override
	public ConstateurDTO getById(long id) {
		Constateur constateur=repository.findById(id).get();
//		System.out.println("jjjjjjjjjjj"+constateur);
		return mapper.map(constateur,ConstateurDTO.class);
	}

	@Override
	public constateur1DTO getById1(long id) {
		Constateur constateur=repository.findById(id).get();
		System.out.println("jjjjjjjjjjj"+constateur);
		return mapper.map(constateur,constateur1DTO.class);
	}
}
