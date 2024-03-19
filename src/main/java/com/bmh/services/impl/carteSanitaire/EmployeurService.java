package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.Repositories.carteSanitaire.EmployeurRepository;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IEmployeur;
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
public class EmployeurService implements IEmployeur {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final EmployeurRepository employeurRepository;
    private final Mapper mapper;

    public EmployeurService(EmployeurRepository employeurRepository, Mapper mapper) {
        this.employeurRepository = employeurRepository;
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
    public Employeur add(EmployeurDto employeurDto) {
        return mapper.map(employeurRepository.save(mapper.map(employeurDto, Employeur.class)), Employeur.class);
    }
    @Override
    public Page<EmployeurDto> AllPagination(Pageable pageable) {
        return employeurRepository.findAll(pageable).map(employeur -> mapper.map(employeur, EmployeurDto.class));
    }



    @Override
    public void update(long id, EmployeurDto employeurDto) {
        if (!employeurRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        employeurDto.setId(id);
        mapper.map(employeurRepository.save(mapper.map(employeurDto, Employeur.class)), EmployeurDto.class);
    }

    @Override
    public List<EmployeurDto> getALl() {
        return mapper.mapList(employeurRepository.findAll(), EmployeurDto.class);
    }

    @Override
    public EmployeurDto getById(long id) {
        Employeur employeur = employeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Employeur not found"));
        return mapper.map(employeur, EmployeurDto.class);
    }

    @Override
    public void delete(long id) {
        if (!employeurRepository.existsById(id)) {
            throw new RuntimeException("Employeur does not exist");
        }
        try {
            employeurRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
