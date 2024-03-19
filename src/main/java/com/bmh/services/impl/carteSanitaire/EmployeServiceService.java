package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employe;
import com.bmh.Repositories.carteSanitaire.EmployeRepository;
import com.bmh.beans.controle_sanitaire.EmployeDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IEmployeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EmployeServiceService implements IEmployeService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final EmployeRepository employeRepository;
    private final Mapper mapper;

    public EmployeServiceService(EmployeRepository employeRepository, Mapper mapper) {
        this.employeRepository = employeRepository;
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
    public Employe add(EmployeDto employeDto) {
        Employe employe = employeRepository.save(mapper.map(employeDto, Employe.class));
        return employe;
    }

    @Override
    public List<EmployeDto> getALl() {
        return mapper.mapList(employeRepository.findAll(), EmployeDto.class);
    }

    @Override
    public EmployeDto getById(long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employe not found"));
        return mapper.map(employe, EmployeDto.class);
    }

    @Override
    public void update(long id, EmployeDto employeDto) {
        if (!employeRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        employeDto.setId(id);
        mapper.map(employeRepository.save(mapper.map(employeDto, Employe.class)), EmployeDto.class);
    }

    @Override
    public void delete(long id) {
        if (!employeRepository.existsById(id)) {
            throw new RuntimeException("Employe does not exist");
        }
        try {
            employeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
