package com.bmh.services.impl;

import com.bmh.Models.Sortie;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.Repositories.SortieRepository;
import com.bmh.Repositories.carteSanitaire.EmployeurRepository;
import com.bmh.beans.SortieDTO;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.services.ISortieService;
import com.bmh.services.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SortieImpl implements ISortieService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final SortieRepository sortieRepository;
    private final Mapper mapper;

    public SortieImpl(SortieRepository sortieRepository, Mapper mapper) {
        this.sortieRepository = sortieRepository;
        this.mapper = mapper;
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
    public Sortie add(SortieDTO sortieDTO) {
        Sortie sortie = sortieRepository.save(mapper.map(sortieDTO, Sortie.class));
        return sortie;
    }

    @Override
    public Page<SortieDTO> AllPagination(Pageable pageable) {
        return sortieRepository.findAll(pageable).map(sortie -> mapper.map(sortie, SortieDTO.class));
    }

    @Override
    public SortieDTO update(long id, SortieDTO sortieDTO) {
        if (!sortieRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        sortieDTO.setId(id);
       return mapper.map(sortieRepository.save(mapper.map(sortieDTO, Sortie.class)), SortieDTO.class);
    }

    @Override
    public List<SortieDTO> getALl() {
        return mapper.mapList(sortieRepository.findAll(), SortieDTO.class);
    }

    @Override
    public SortieDTO getById(long id) {
        Sortie sortie = sortieRepository.findById(id).orElseThrow(() -> new RuntimeException("Sortie not found"));
        return mapper.map(sortie, SortieDTO.class);
    }

    @Override
    public void delete(long id) {
        if (!sortieRepository.existsById(id)) {
            throw new RuntimeException("Sortie does not exist");
        }
        try {
            sortieRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
