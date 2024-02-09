package com.bmh.services.impl.carteSanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.PersonnesEtab.Morale;
import com.bmh.Repositories.carteSanitaire.PersonnesEtabRepository.MoraleRepository;

import com.bmh.beans.controle_sanitaire.PersonnesEtab.MoraleDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.PersonnesEtab.IMoraleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoraleService implements IMoraleService {
    private final MoraleRepository moraleRepository;
    private Mapper mapper;

    public MoraleService(MoraleRepository moraleRepository, Mapper mapper) {
        this.moraleRepository = moraleRepository;
        this.mapper = mapper;
    }

    @Override
    public Morale add(MoraleDto moraleDto) {
        return mapper.map(moraleRepository.save(mapper.map(moraleDto, Morale.class)),Morale.class);
    }

    @Override
    public List<MoraleDto> getALl() {
        return mapper.mapList(moraleRepository.findAll(), MoraleDto.class);
    }

    @Override
    public MoraleDto getById(long id) {
        Morale morale=moraleRepository.findById(id).get();
        return mapper.map(morale,MoraleDto.class);
    }

    @Override
    public void update(long id, MoraleDto moraleDto ) {
        if(!moraleRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        moraleDto.setId(id);
        mapper.map(moraleRepository.save(mapper.map(moraleDto, Morale.class)), MoraleDto.class);
    }

    @Override
    public void delete(long id) {
        if(!moraleRepository.existsById(id)) {
            throw new RuntimeException("personne n'éxiste pas");
        }
        try {
            moraleRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }
}
