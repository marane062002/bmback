package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.medecinLegale.EntermentObstacle;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.Models.medecinLegale.SageFemme;
import com.bmh.Models.medecinLegale.Transfert;
import com.bmh.Repositories.ConducteurRepository;
import com.bmh.Repositories.VehiculeRepository;
import com.bmh.Repositories.medecinLegale.TransfertRepository;
import com.bmh.beans.medecinLegale.SageFemmeDTO;
import com.bmh.beans.medecinLegale.TransfertDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.TransfertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TransfertServiceImpl implements TransfertService {
	private final TransfertRepository repository;
	private final Mapper mapper;
	private final VehiculeRepository vehiculeRepository;
	private final ConducteurRepository conducteurRepository;

	public TransfertServiceImpl(TransfertRepository repository, Mapper mapper, VehiculeRepository vehiculeRepository, ConducteurRepository conducteurRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.vehiculeRepository = vehiculeRepository;
		this.conducteurRepository = conducteurRepository;
	}

	@Override
	public Transfert add(TransfertDTO transfertDTO) {
		try{
			Optional<Conducteur> conducteur=conducteurRepository.findById(transfertDTO.getConducteur().getId());
			Optional<Vehicule> vehicule=vehiculeRepository.findById(transfertDTO.getVehicule().getId());
			if(conducteur.isPresent()&&vehicule.isPresent()){
				Transfert transfert=mapper.map(transfertDTO, Transfert.class);
				transfert.setVehicule(vehicule.get());
				transfert.setConducteur(conducteur.get());
				return repository.save(transfert);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout: " + ex.getMessage());
		}
	}

	@Override
	public List<TransfertDTO> getALl() {
		return mapper.mapList(repository.findAll(), TransfertDTO.class);
	}

	@Override
	public TransfertDTO getById(long id) {
		Transfert transfert=repository.findById(id).get();
		return mapper.map(transfert,TransfertDTO.class);
	}

	@Override
	public void update(long id, TransfertDTO transfertDTO) {
		Optional<Transfert> transfert=repository.findById(id);
		if(transfert.isPresent()){
			Transfert transfert1=transfert.get();
			transfert1.setVehicule(transfertDTO.getVehicule());
			transfert1.setConducteur(transfertDTO.getConducteur());
			transfert1.setPointDepart(transfertDTO.getPointDepart());
			transfert1.setPointArrive(transfertDTO.getPointArrive());
			transfert1.setLieuInhumation(transfertDTO.getLieuInhumation());
			transfert1.setRemarque(transfertDTO.getRemarque());
			repository.save(transfert1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Transfert> transfert=repository.findById(id);
		if(transfert.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
