package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.*;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.Repositories.ArrondissementRepository;
import com.bmh.Repositories.CommuneRepository;
import com.bmh.Repositories.IConstateurRepository;
import com.bmh.Repositories.QuartierRepository;
import com.bmh.Repositories.medecinLegale.DecesNaturelRepository;
import com.bmh.Repositories.medecinLegale.EntrementInhumationRepository;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.services.Mapper;
import com.bmh.services.impl.ArrondissementService;
import com.bmh.services.impl.CommuneService;
import com.bmh.services.impl.ConstateurImpl;
import com.bmh.services.impl.QuartierService;
import com.bmh.services.medecinLegale.IDecesNaturelService;
import com.bmh.specification.DecesSpecifications;
import com.bmh.specification.EtabSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DecesNaturelService implements IDecesNaturelService {
	private final DecesNaturelRepository repository;
	private Mapper mapper;

	private final ArrondissementRepository repositoryA;
	private final IConstateurRepository repositoryC;
	private final CommuneRepository repositoryCm;
	private final QuartierRepository repositoryQ;

	public DecesNaturelService(DecesNaturelRepository repository, Mapper mapper, ArrondissementService serviceA, ConstateurImpl serviceC, IConstateurRepository repositoryC, CommuneService serviceCm, QuartierService serviceQ, ArrondissementRepository repositoryA, CommuneRepository repositoryCm, QuartierRepository repositoryQ) {
		this.repository = repository;
		this.mapper = mapper;
		this.repositoryA = repositoryA;
		this.repositoryCm = repositoryCm;
		this.repositoryQ = repositoryQ;
		this.repositoryC = repositoryC;
	}
	@Override
	public Page<DecesNaturelDTO> getAllPaginationWithFilter(LocalDate dateDeces, Arrondissement arrondissement, StatusCadavre statusCadavre, Pageable pageable) {
		Specification<DecesNaturel> spec = Specification.where(null);
		if (dateDeces != null) {
			spec = spec.and(DecesSpecifications.hasDateDeces(dateDeces));
		}
		if (arrondissement != null) {
			spec = spec.and(DecesSpecifications.hasArrondissement(arrondissement));
		}
		if (statusCadavre != null) {
			spec = spec.and(DecesSpecifications.hasStatusCadavre(statusCadavre));
		}
		return repository.findAll(spec, pageable)
				.map(etabs -> mapper.map(etabs, DecesNaturelDTO.class));
	}
	@Override
	public List<Map<String, Object>> countDeathsByArrondissementAndSexe() {
		return repository.countDeathsByArrondissementAndSexe();
	}
	@Override
	public List<Map<String, Object>> countDeathsByConstaterAndSexe() {
		return repository.countDeathsByConstaterAndSexe();
	}
	@Override
	public DecesNaturel add(DecesNaturelDTO decesNaturelDTO) {
		try {
			Optional<Constateur> constateur = repositoryC.findById(decesNaturelDTO.getConstateur().getId());
			Optional<Quartier> quartier = repositoryQ.findById(decesNaturelDTO.getQuartier().getId());
			Optional<Commune> commune=repositoryCm.findById(decesNaturelDTO.getCommune().getId());
			Optional<Arrondissement> arrondissement=repositoryA.findById(decesNaturelDTO.getArrondissement().getId());
			if (constateur.isPresent() && quartier.isPresent() && commune.isPresent() && arrondissement.isPresent()) {
				DecesNaturel decesNaturel = mapper.map(decesNaturelDTO, DecesNaturel.class);
				decesNaturel.setConstateur(constateur.get());
				decesNaturel.setQuartier(quartier.get());
				decesNaturel.setCommune(commune.get());
				decesNaturel.setArrondissement(arrondissement.get());

				// Enregistrement de l'entité DecesNaturel dans la base de données
				return repository.save(decesNaturel);
			} else {
				throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
		}
	}

	@Override
	public List<DecesNaturelDTO> getALl() {
		return mapper.mapList(repository.findAll(),DecesNaturelDTO.class);
	}

	@Override
	public DecesNaturelDTO getById(long id) {
		DecesNaturel decesNaturel=repository.findById(id).get();
		return mapper.map(decesNaturel,DecesNaturelDTO.class);
	}

	@Override
	public void update(long id, DecesNaturelDTO decesNaturelDTO) {
		Optional<DecesNaturel> decesNaturel=repository.findById(id);
		if(decesNaturel.isPresent()){
			DecesNaturel decesNaturel1=decesNaturel.get();
			decesNaturel1.setNom(decesNaturelDTO.getNom());
			decesNaturel1.setPrenom(decesNaturelDTO.getPrenom());
			decesNaturel1.setCin(decesNaturelDTO.getCin());
			decesNaturel1.setNationalite(decesNaturelDTO.getNationalite());
			decesNaturel1.setSexe(decesNaturelDTO.getSexe());
			decesNaturel1.setCause(decesNaturelDTO.getCause());
			decesNaturel1.setConstater(decesNaturelDTO.getConstater());
			decesNaturel1.setDate(decesNaturelDTO.getDate());
			decesNaturel1.setCommune(decesNaturelDTO.getCommune());
			decesNaturel1.setNumDeces(decesNaturelDTO.getNumDeces());
			decesNaturel1.setNumRegistre(decesNaturelDTO.getNumRegistre());
//			decesNaturel1.setAdresseDeces(decesNaturelDTO.getAdresseDeces());
			decesNaturel1.setLieu(decesNaturelDTO.getLieu());
			decesNaturel1.setArrondissement(decesNaturelDTO.getArrondissement());
			decesNaturel1.setConstateur(decesNaturelDTO.getConstateur());
			decesNaturel1.setQuartier(decesNaturelDTO.getQuartier());
			decesNaturel1.setAdresseResidence(decesNaturelDTO.getAdresseResidence());
			decesNaturel1.setDescriptionDec(decesNaturelDTO.getDescriptionDec());
			decesNaturel1.setStatusCadavre(decesNaturelDTO.getStatusCadavre());
			decesNaturel1.setNomCim(decesNaturelDTO.getNomCim());
			decesNaturel1.setNumTombe(decesNaturelDTO.getNumTombe());
			repository.save(decesNaturel1);
		}
	}

	@Override
	public void delete(long id) {
		Optional<DecesNaturel> decesNaturel=repository.findById(id);
		if(decesNaturel.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
	@Override
	public Page<DecesNaturelDTO> AllPagination(Pageable pageable) {
		Page<DecesNaturelDTO> decesNaturelDTOS=repository.findAll(pageable).map(deces -> mapper.map(deces, DecesNaturelDTO.class));
		return repository.findAll(pageable).map(deces -> mapper.map(deces, DecesNaturelDTO.class));
	}

}
