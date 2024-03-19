package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Commune;
import com.bmh.Models.Constateur;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.Quartier;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Models.medecinLegale.Cadavre;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.Repositories.ArrondissementRepository;
import com.bmh.Repositories.CommuneRepository;
import com.bmh.Repositories.IConstateurRepository;
import com.bmh.Repositories.QuartierRepository;
import com.bmh.Repositories.medecinLegale.CadavreRepository;
import com.bmh.Repositories.medecinLegale.EnterrementObstacleRepository;
import com.bmh.Repositories.medecinLegale.EntrementInhumationRepository;
import com.bmh.Repositories.medecinLegale.ObstacleDefuntsRepository;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.EnterrementObstacleDTO;
import com.bmh.beans.medecinLegale.ObstacleDefuntsDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.ObstacleService;
import com.bmh.specification.DecesSpecifications;
import com.bmh.specification.ObstacleSpecifications;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ObstacleDefuntsServiceImpl implements ObstacleService {
	private final ObstacleDefuntsRepository repository;
	private final Mapper mapper;
	private final ArrondissementRepository repositoryA;
	private final IConstateurRepository repositoryC;
	private final CommuneRepository repositoryCm;
	private final QuartierRepository repositoryQ;
	private final CadavreRepository cadavreRepository;
	private final EntrementInhumationRepository entrementInhumationRepository;
	@Value("${file.upload-dir}")
	private String uploadDir;
	public ObstacleDefuntsServiceImpl(ObstacleDefuntsRepository repository, Mapper mapper, ArrondissementRepository repositoryA, IConstateurRepository repositoryC, CommuneRepository repositoryCm, QuartierRepository repositoryQ, CadavreRepository cadavreRepository,  EntrementInhumationRepository entrementInhumationRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.repositoryA = repositoryA;
		this.repositoryC = repositoryC;
		this.repositoryCm = repositoryCm;
		this.repositoryQ = repositoryQ;
		this.cadavreRepository = cadavreRepository;
		this.entrementInhumationRepository = entrementInhumationRepository;
	}


	@Override
	public Page<ObstacleDefuntsDTO> getAllPaginationWithFilter(LocalDate dateDeces, Arrondissement arrondissement, StatusCadavre statusCadavre, Pageable pageable) {
		Specification<ObstacleDefunts> spec = Specification.where(null);
		if (dateDeces != null) {
			spec = spec.and(ObstacleSpecifications.hasDateDeces(dateDeces));
		}
		if (arrondissement != null) {
			spec = spec.and(ObstacleSpecifications.hasArrondissement(arrondissement));
		}
		if (statusCadavre != null) {
			spec = spec.and(ObstacleSpecifications.hasStatusCadavre(statusCadavre));
		}
		return repository.findAll(spec, pageable)
				.map(etabs -> mapper.map(etabs, ObstacleDefuntsDTO.class));
	}

	public void storeFile(MultipartFile file, String fileName) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		Path filePath = uploadPath.resolve(fileName);
		try {
			Files.write(filePath, file.getBytes());
		} catch (IOException e) {
			throw new RuntimeException("Failed to store file: " + fileName, e);
		}
	}
	@Override
	public List<Map<String, Object>> countDefuntsByNationaliteAndSexe() {
		return repository.countDefuntsByNationaliteAndSexe();
	}

//	public Employeur add(EmployeurDto employeurDto, MultipartFile pieceJointes) {
//		if (pieceJointes != null && !pieceJointes.isEmpty()) {
//			try {
//				String fileName = System.currentTimeMillis() + "_" + pieceJointes.getOriginalFilename();
//				storeFile(pieceJointes);
//				employeurDto.setPieceJointes(fileName);
//			} catch (IOException e) {
//				throw new RuntimeException("Failed to store file", e);
//			}
//		}
//		return mapper.map(employeurRepository.save(mapper.map(employeurDto, Employeur.class)), Employeur.class);
//	}
	@Override
	public ObstacleDefunts add( ObstacleDefuntsDTO obstacleDefuntsDTO) {
//		if (pcDeclarant != null && !pcDeclarant.isEmpty() && pcConstateur != null && !pcConstateur.isEmpty() && pcJointeDefunts != null && !pcJointeDefunts.isEmpty()) {
//			String pieceDeclarant = System.currentTimeMillis() + "_" + pcDeclarant.getOriginalFilename();
//			String pieceConstateur = System.currentTimeMillis() + "_" + pcConstateur.getOriginalFilename();
//			String pieceJointeDefunts = System.currentTimeMillis() + "_" + pcJointeDefunts.getOriginalFilename();
//			try {
//				storeFile(pcDeclarant, pieceDeclarant);
//				storeFile(pcConstateur, pieceConstateur);
//				storeFile(pcJointeDefunts, pieceJointeDefunts);
//			} catch (IOException e) {
//				throw new RuntimeException("Failed to store files", e);
//			}
//			obstacleDefuntsDTO.setPcJointeDefunts(pieceDeclarant);
//			obstacleDefuntsDTO.setPcConstateur(pieceConstateur);
//			obstacleDefuntsDTO.setPcDeclarant(pieceDeclarant);
//		}

		ObstacleDefunts obstacleDefunts = repository.save(mapper.map(obstacleDefuntsDTO, ObstacleDefunts.class));
		return obstacleDefunts;
	}

	@Override
	public List<ObstacleDefuntsDTO> getALl() {
		return mapper.mapList(repository.findAll(), ObstacleDefuntsDTO.class);
	}

	@Override
	public ObstacleDefuntsDTO getById(long id) {
		ObstacleDefunts obstacleDefunts=repository.findById(id).get();
		return mapper.map(obstacleDefunts,ObstacleDefuntsDTO.class);
	}

	@Override
	public Page<ObstacleDefuntsDTO> AllPagination(Pageable pageable){
		Page<ObstacleDefuntsDTO> obstacleDefuntsDTOS=repository.findAll(pageable).map(obs -> mapper.map(obs, ObstacleDefuntsDTO.class));
		return repository.findAll(pageable).map(obs -> mapper.map(obs, ObstacleDefuntsDTO.class));
	};

// if (!re.existsById(id)) {
//		throw new RuntimeException("RESOURCE_NOT_FOUND");
//	}
//        employeDto.setId(id);
//        if (photo != null && !photo.isEmpty() && pieceJointe != null && !pieceJointe.isEmpty()) {
//		String fileNamePhoto = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
//		String fileNamePiece = System.currentTimeMillis() + "_" + pieceJointe.getOriginalFilename();
//		try {
//			storeFile(photo, fileNamePhoto);
//			storeFile(pieceJointe, fileNamePiece);
//		} catch (IOException e) {
//			throw new RuntimeException("Failed to store files", e);
//		}
//		employeDto.setPhoto(fileNamePhoto);
//		employeDto.setPieceJointe(fileNamePiece);
//	}
//        mapper.map(employeRepository.save(mapper.map(employeDto, Employe.class)), EmployeDto.class);
	@Override
	public void update(long id, ObstacleDefuntsDTO obstacleDefuntsDTO) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("RESOURCE_NOT_FOUND");
		}
		obstacleDefuntsDTO.setId(id);
//		if (pcDeclarant != null && !pcDeclarant.isEmpty() && pcConstateur != null && !pcConstateur.isEmpty() && pcJointeDefunts != null && !pcJointeDefunts.isEmpty()) {
//			String pieceDeclarant = System.currentTimeMillis() + "_" + pcDeclarant.getOriginalFilename();
//			String pieceConstateur = System.currentTimeMillis() + "_" + pcConstateur.getOriginalFilename();
//			String pieceJointeDefunts = System.currentTimeMillis() + "_" + pcJointeDefunts.getOriginalFilename();
//			try {
//				storeFile(pcDeclarant, pieceDeclarant);
//				storeFile(pcConstateur, pieceConstateur);
//				storeFile(pcJointeDefunts, pieceJointeDefunts);
//			} catch (IOException e) {
//				throw new RuntimeException("Failed to store files", e);
//			}
//			obstacleDefuntsDTO.setPcJointeDefunts(pieceDeclarant);
//			obstacleDefuntsDTO.setPcConstateur(pieceConstateur);
//			obstacleDefuntsDTO.setPcDeclarant(pieceDeclarant);
//		}

		mapper.map(repository.save(mapper.map(obstacleDefuntsDTO, ObstacleDefunts.class)), ObstacleDefuntsDTO.class);
	}


	@Override
	public void delete(long id) {
		Optional<ObstacleDefunts> obstacleDefunts=repository.findById(id);

		if(obstacleDefunts.isPresent()){
			obstacleDefunts.get().setArrondissement(null);
			obstacleDefunts.get().setCommune(null);
			obstacleDefunts.get().setQuartier(null);
			obstacleDefunts.get().setConstateur(null);

		List<Cadavre> cadavres=	cadavreRepository.findByObstacleDefunts_Id(id);
		cadavres.forEach(cadavre->{
			cadavre.setObstacleDefunts(null);
		});

//			(Arrondissement, Commune, Quartier, Constateur).
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("obst avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
