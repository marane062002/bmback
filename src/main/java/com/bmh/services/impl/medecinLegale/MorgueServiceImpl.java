package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.Morgue;
import com.bmh.Repositories.medecinLegale.MorgueRepository;
import com.bmh.beans.medecinLegale.MorgueDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.MorgueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class MorgueServiceImpl implements MorgueService {
	@Value("${file.upload-dir}")
	private String uploadDir;
	private final MorgueRepository repository;
	private final Mapper mapper;

	public MorgueServiceImpl(MorgueRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public void storeFile(MultipartFile file) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		Path filePath = uploadPath.resolve(fileName);
		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, filePath);
		}
	}

	@Override
	public Morgue add(MorgueDTO morgueDTO) {
		return mapper.map(repository.save(mapper.map(morgueDTO,Morgue.class)),Morgue.class);
	}

	@Override
	public List<MorgueDTO> getALl() {
		return mapper.mapList(repository.findAll(),MorgueDTO.class);
	}

	@Override
	public MorgueDTO getById(long id) {
		Morgue morgue=repository.findById(id).get();
		return mapper.map(morgue,MorgueDTO.class);
	}

//	@Override
//	public Page<MorgueDTO> AllPagination(Pageable pageable) {
//		return repository.findAll(pageable).map(morgue -> mapper.map(morgue, MorgueDTO.class));
//	}

	@Override
	public void update(long id, MorgueDTO morgueDTO) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("RESOURCE_NOT_FOUND");
		}
		morgueDTO.setId(id);
//		if (pcJointe != null && !pcJointe.isEmpty()) {
//			try {
//				String fileName = System.currentTimeMillis() + "_" + pcJointe.getOriginalFilename();
//				storeFile(pcJointe);
//				morgueDTO.setPcJointe(fileName);
//			} catch (IOException e) {
//				throw new RuntimeException("Failed to store file", e);
//			}
//		}
		mapper.map(repository.save(mapper.map(morgueDTO, Morgue.class)), MorgueDTO.class);
	}

	@Override
	public void delete(long id) {
		Optional<Morgue> morgue=repository.findById(id);
		if(morgue.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}

	@Override
	public Page<MorgueDTO> AllPagination(Pageable pageable) {
		return repository.findAll(pageable).map(morgue -> mapper.map(morgue, MorgueDTO.class));
	}
}
