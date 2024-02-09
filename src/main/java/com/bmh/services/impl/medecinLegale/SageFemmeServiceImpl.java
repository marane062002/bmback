package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.Examen;
import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.SageFemme;
import com.bmh.Repositories.medecinLegale.SageFemmeRepository;
import com.bmh.beans.medecinLegale.SageFemmeDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.SageFemmeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SageFemmeServiceImpl implements SageFemmeService {
	private final SageFemmeRepository repository;
	private final Mapper mapper;

	public SageFemmeServiceImpl(SageFemmeRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public SageFemme add(SageFemmeDTO sageFemmeDTO) {
		return mapper.map(repository.save(mapper.map(sageFemmeDTO, SageFemme.class)),SageFemme.class);
	}

	@Override
	public List<SageFemmeDTO> getALl() {
		return mapper.mapList(repository.findAll(),SageFemmeDTO.class);
	}

	@Override
	public SageFemmeDTO getById(long id) {
		SageFemme sageFemme=repository.findById(id).get();
		return mapper.map(sageFemme,SageFemmeDTO.class);
	}

	@Override
	public void update(long id, SageFemmeDTO sageFemmeDTO) {
		Optional<SageFemme> sageFemme=repository.findById(id);
		if(sageFemme.isPresent()){
			SageFemme sageFemme1=sageFemme.get();
			sageFemme1.setNom(sageFemmeDTO.getNom());
			sageFemme1.setPrenom(sageFemmeDTO.getPrenom());
			sageFemme1.setCin(sageFemmeDTO.getCin());
			sageFemme1.setDate(sageFemmeDTO.getDate());
			sageFemme1.setTel(sageFemmeDTO.getTel());
			sageFemme1.setAdresse(sageFemmeDTO.getAdresse());
			repository.save(sageFemme1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<SageFemme> sageFemme=repository.findById(id);
		if(sageFemme.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
