package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Action;
import com.bmh.Models.controle_sanitaire.Programmes;
import com.bmh.Repositories.carteSanitaire.ProgrammeRepository;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IActionService;
import com.bmh.services.carteSanitaire.IProgrammeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammeService implements IProgrammeService{
     private final ProgrammeRepository programmeRepository;
     private final Mapper mapper;

    public ProgrammeService(ProgrammeRepository programmeRepository, Mapper mapper) {
        this.programmeRepository = programmeRepository;
        this.mapper = mapper;
    }

    @Override
    public Programmes add(ProgrammeDto programmeDto) {
        return mapper.map(programmeRepository.save(mapper.map(programmeDto, Programmes.class)),Programmes.class);
    }

    @Override
    public Page<ProgrammeDto> AllPagination(Pageable pageable){
        return programmeRepository.findAll(pageable).map(programmes -> mapper.map(programmes, ProgrammeDto.class));
    };

    @Override
    public List<ProgrammeDto> getALl() {
        return mapper.mapList(programmeRepository.findAll(), ProgrammeDto.class);
    }

    @Override
    public ProgrammeDto getById(long id) {
        Programmes programmes=programmeRepository.findById(id).get();
        return mapper.map(programmes,ProgrammeDto.class);
    }

    @Override
    public void update(long id, ProgrammeDto programmeDto ) {
        if(!programmeRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        programmeDto.setId(id);
        mapper.map(programmeRepository.save(mapper.map(programmeDto, Programmes.class)), ProgrammeDto.class);
    }

    @Override
    public void delete(long id) {
        if(!programmeRepository.existsById(id)) {
            throw new RuntimeException("action n'éxiste pas");
        }
        try {
            programmeRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }
}
