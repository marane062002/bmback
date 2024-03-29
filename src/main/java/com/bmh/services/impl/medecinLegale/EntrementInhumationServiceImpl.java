package com.bmh.services.impl.medecinLegale;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.Repositories.medecinLegale.EntrementInhumationRepository;
import com.bmh.beans.medecinLegale.EntrementInhumationDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.EntrementInhumationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EntrementInhumationServiceImpl implements EntrementInhumationService {

	private final EntrementInhumationRepository entrementInhumationRepository;
	private final Mapper mapper;

	public EntrementInhumationServiceImpl(EntrementInhumationRepository entrementInhumationRepository, Mapper mapper) {
		this.entrementInhumationRepository = entrementInhumationRepository;
		this.mapper = mapper;
	}

	@Override
	public EntrementInhumation add(EntrementInhumationDTO entrementInhumationDTO) {
		return mapper.map(entrementInhumationRepository.save(mapper.map(entrementInhumationDTO, EntrementInhumation.class)), EntrementInhumation.class);
	}
	@Override
	public Page<EntrementInhumationDTO> AllPagination(Pageable pageable) {
		return entrementInhumationRepository.findAll(pageable).map(entrementInhumation -> mapper.map(entrementInhumation, EntrementInhumationDTO.class));
	}



	@Override
	public void update(long id, EntrementInhumationDTO entrementInhumationDTO) {
		if (!entrementInhumationRepository.existsById(id)) {
			throw new RuntimeException("RESOURCE_NOT_FOUND");
		}
		entrementInhumationDTO.setId(id);
		mapper.map(entrementInhumationRepository.save(mapper.map(entrementInhumationDTO, EntrementInhumation.class)), EntrementInhumationDTO.class);
	}

	@Override
	public List<EntrementInhumationDTO> getALl() {
		return mapper.mapList(entrementInhumationRepository.findAll(), EntrementInhumationDTO.class);
	}

	@Override
	public EntrementInhumationDTO getById(long id) {
		EntrementInhumation entrementInhumation = entrementInhumationRepository.findById(id).orElseThrow(() -> new RuntimeException("Enterrement not found"));
		return mapper.map(entrementInhumation, EntrementInhumationDTO.class);
	}

	@Override
	public void delete(long id) {
		if (!entrementInhumationRepository.existsById(id)) {
			throw new RuntimeException("Enterrement does not exist");
		}
		try {
			entrementInhumationRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
