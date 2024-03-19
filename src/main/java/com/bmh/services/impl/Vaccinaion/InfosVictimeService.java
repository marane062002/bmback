package com.bmh.services.impl.Vaccinaion;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.vaccination.InfosVictime;
import com.bmh.Repositories.Vaccination.InfosVictimeRepository;
import com.bmh.beans.VaccinationDTO.InfosVictimeDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.services.Mapper;
import com.bmh.services.Vaccination.IinfosVictimeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfosVictimeService implements IinfosVictimeService {

    private final InfosVictimeRepository infosVictimeRepository;
    private final Mapper mapper;

    public InfosVictimeService(InfosVictimeRepository infosVictimeRepository, Mapper mapper) {
        this.infosVictimeRepository = infosVictimeRepository;
        this.mapper = mapper;
    }


    @Override
    public InfosVictime add(InfosVictimeDto infosVictimeDto) {
        return mapper.map(infosVictimeRepository.save(mapper.map(infosVictimeDto, InfosVictime.class)),InfosVictime.class);
    }

    @Override
    public List<InfosVictimeDto> getALl() {
        return mapper.mapList(infosVictimeRepository.findAll(), InfosVictimeDto.class);
    }

    @Override
    public InfosVictimeDto getById(long id) {
        InfosVictime infosVictime=infosVictimeRepository.findById(id).get();
        return mapper.map(infosVictime,InfosVictimeDto.class);
    }

    @Override
    public InfosVictime update(long id, InfosVictimeDto infosVictimeDto) {
        if(!infosVictimeRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        infosVictimeDto.setId(id);
        return mapper.map(infosVictimeRepository.save(mapper.map(infosVictimeDto, InfosVictime.class)), InfosVictime.class);
    }

    @Override
    public void delete(long id) {
        if(!infosVictimeRepository.existsById(id)) {
            throw new RuntimeException("établissement n'éxiste pas");
        }
        try {
            infosVictimeRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }

}
