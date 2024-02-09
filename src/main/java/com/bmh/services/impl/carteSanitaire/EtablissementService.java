package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.Programmes;
import com.bmh.Repositories.carteSanitaire.EtablissementRepository;
import com.bmh.Repositories.carteSanitaire.ProgrammeRepository;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IEtablissementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtablissementService implements IEtablissementService {
   private final EtablissementRepository etablissementRepository;
   private final Mapper mapper;

    public EtablissementService(EtablissementRepository etablissementRepository, Mapper mapper) {
        this.etablissementRepository = etablissementRepository;
        this.mapper = mapper;
    }


    @Override
    public Etablissement add(EtablissementDTO etablissementDTO) {
        return mapper.map(etablissementRepository.save(mapper.map(etablissementDTO, Etablissement.class)),Etablissement.class);
    }

    @Override
    public List<EtablissementDTO> getALl() {
        return mapper.mapList(etablissementRepository.findAll(), EtablissementDTO.class);
    }


    @Override
    public EtablissementDTO getById(long id) {
        Etablissement etablissement=etablissementRepository.findById(id).get();
        return mapper.map(etablissement,EtablissementDTO.class);
    }

    @Override
    public Page<EtablissementDTO> AllPagination(Pageable pageable){
        Page<EtablissementDTO> etablissementDTOS=etablissementRepository.findAll(pageable).map(etabs -> mapper.map(etabs, EtablissementDTO.class));
        return etablissementRepository.findAll(pageable).map(etabs -> mapper.map(etabs, EtablissementDTO.class));
    };

    @Override
    public void update(long id, EtablissementDTO etablissementDTO ) {
        if(!etablissementRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        etablissementDTO.setId(id);
        mapper.map(etablissementRepository.save(mapper.map(etablissementDTO, Etablissement.class)), EtablissementDTO.class);
    }

    @Override
    public void delete(long id) {
        if(!etablissementRepository.existsById(id)) {
            throw new RuntimeException("établissement n'éxiste pas");
        }
        try {
            etablissementRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }
}
