package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.Morgue;
import com.bmh.Repositories.medecinLegale.FourgonRepository;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.FourgonService;
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
public class FourgonServiceImpl implements FourgonService {

	@Value("${file.upload-dir}")
	private String uploadDir;
	private final FourgonRepository repository;
	private final Mapper mapper;

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

	public FourgonServiceImpl(FourgonRepository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Fourgon add(FourgonDTO fourgonDTO,MultipartFile pcj) {
		if (pcj != null && !pcj.isEmpty()) {
			try {
				String fileName = System.currentTimeMillis() + "_" + pcj.getOriginalFilename();
				storeFile(pcj);
				fourgonDTO.setPcj(fileName);
			} catch (IOException e) {
				throw new RuntimeException("Failed to store file", e);
			}
		}
		return mapper.map(repository.save(mapper.map(fourgonDTO, Fourgon.class)), Fourgon.class);
	}

	@Override
	public Page<FourgonDTO> AllPagination(Pageable pageable) {
		return repository.findAll(pageable).map(fourgon -> mapper.map(fourgon, FourgonDTO.class));
	}

	@Override
	public List<FourgonDTO> getALl() {
		return mapper.mapList(repository.findAll(),FourgonDTO.class);
	}

	@Override
	public FourgonDTO getById(long id) {
		Fourgon fourgon=repository.findById(id).get();
		return mapper.map(fourgon,FourgonDTO.class);
	}

	@Override
	public void update(long id, FourgonDTO fourgonDTO,MultipartFile pcj) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("RESOURCE_NOT_FOUND");
		}
		fourgonDTO.setId(id);
		if (pcj != null && !pcj.isEmpty()) {
			try {
				String fileName = System.currentTimeMillis() + "_" + pcj.getOriginalFilename();
				storeFile(pcj);
				fourgonDTO.setPcj(fileName);
			} catch (IOException e) {
				throw new RuntimeException("Failed to store file", e);
			}
		}
		mapper.map(repository.save(mapper.map(fourgonDTO, Fourgon.class)), FourgonDTO.class);
	}

	@Override
	public void delete(long id) {
		Optional<Fourgon> fourgon=repository.findById(id);
		if(fourgon.isPresent()){
			repository.deleteById(id);
		}else {
			throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
		}
	}
}
