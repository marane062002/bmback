package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.ActeMariage;
import com.bmh.Models.medecinLegale.ConstateurNouveauNe;
import com.bmh.Repositories.medecinLegale.ConstateurNouveauNeRepository;
import com.bmh.beans.medecinLegale.ConstateurNouveauNeDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.ConstateurNouveauNeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ConstateurNouveauNeServiceImpl implements ConstateurNouveauNeService {
	private final ConstateurNouveauNeRepository repository;
	private final Mapper mapper;

	public ConstateurNouveauNeServiceImpl(ConstateurNouveauNeRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ConstateurNouveauNe add(ConstateurNouveauNeDTO constateurNouveauNeDTO) {
		return mapper.map(repository.save(mapper.map(constateurNouveauNeDTO, ConstateurNouveauNe.class)),ConstateurNouveauNe.class);
	}

	@Override
	public List<ConstateurNouveauNeDTO> getALl() {
		return mapper.mapList(repository.findAll(),ConstateurNouveauNeDTO.class);
	}

	@Override
	public ConstateurNouveauNeDTO getById(long id) {
		ConstateurNouveauNe constateurNouveauNe=repository.findById(id).get();
		return mapper.map(constateurNouveauNe,ConstateurNouveauNeDTO.class);
	}

	@Override
	public void update(long id, ConstateurNouveauNeDTO constateurNouveauNeDTO) {
		Optional<ConstateurNouveauNe> constateurNouveauNe=repository.findById(id);
		if(constateurNouveauNe.isPresent()){
			ConstateurNouveauNe constateurNouveauNe1=constateurNouveauNe.get();
			constateurNouveauNe1.setNom(constateurNouveauNeDTO.getNom());
			constateurNouveauNe1.setPrenom(constateurNouveauNeDTO.getPrenom());
			constateurNouveauNe1.setCin(constateurNouveauNeDTO.getCin());
			constateurNouveauNe1.setSexe(constateurNouveauNeDTO.getSexe());
			repository.save(constateurNouveauNe1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<ConstateurNouveauNe> constateurNouveauNe=repository.findById(id);
		if(constateurNouveauNe.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
