package com.bmh.services.impl.Vaccinaion;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.Models.vaccination.InfosGenerales;
import com.bmh.Repositories.Vaccination.InfosGeneralesRepository;
import com.bmh.Repositories.carteSanitaire.EmployeurRepository;
import com.bmh.beans.VaccinationDTO.InfosGeneralesDto;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.services.Mapper;
import com.bmh.services.Vaccination.IinfosGeneralesService;
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
public class InfosGeneraleService implements IinfosGeneralesService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final InfosGeneralesRepository infosGeneralesRepository;
    private final Mapper mapper;

    public InfosGeneraleService(InfosGeneralesRepository infosGeneralesRepository, Mapper mapper) {
        this.infosGeneralesRepository = infosGeneralesRepository;
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
    public InfosGenerales add(InfosGeneralesDto infosGeneralesDto) {
        return mapper.map(infosGeneralesRepository.save(mapper.map(infosGeneralesDto, InfosGenerales.class)), InfosGenerales.class);
    }
    @Override
    public Page<InfosGeneralesDto> AllPagination(Pageable pageable) {
        return infosGeneralesRepository.findAll(pageable).map(infos -> mapper.map(infos, InfosGeneralesDto.class));
    }
    
    @Override
    public InfosGenerales update(long id, InfosGeneralesDto infosGeneralesDto) {
        if (!infosGeneralesRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        infosGeneralesDto.setId(id);
       return mapper.map(infosGeneralesRepository.save(mapper.map(infosGeneralesDto, InfosGenerales.class)), InfosGenerales.class);
    }

    @Override
    public List<InfosGeneralesDto> getALl() {
        return mapper.mapList(infosGeneralesRepository.findAll(), InfosGeneralesDto.class);
    }

    @Override
    public InfosGeneralesDto getById(long id) {
        InfosGenerales infosGenerales = infosGeneralesRepository.findById(id).orElseThrow(() -> new RuntimeException("Employeur not found"));
        return mapper.map(infosGenerales, InfosGeneralesDto.class);
    }

    @Override
    public void delete(long id) {
        if (!infosGeneralesRepository.existsById(id)) {
            throw new RuntimeException("Employeur does not exist");
        }
        try {
            infosGeneralesRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
