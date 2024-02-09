package com.bmh.services.impl.carteSanitaire.PersonnesEtab;

import com.bmh.Models.controle_sanitaire.PersonnesEtab.Physique;
import com.bmh.Repositories.carteSanitaire.PersonnesEtabRepository.PhysiqueRepository;
import com.bmh.beans.controle_sanitaire.PersonnesEtab.PhysiqueDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.PersonnesEtab.IPhysiqueService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhysiqeSrvice implements IPhysiqueService {
    private final PhysiqueRepository physiqueRepository;
    private Mapper mapper;

    public PhysiqeSrvice(PhysiqueRepository physiqueRepository, Mapper mapper) {
        this.physiqueRepository = physiqueRepository;
        this.mapper = mapper;
    }

    @Override
    public Physique add(PhysiqueDto physiqueDto) {
        return mapper.map(physiqueRepository.save(mapper.map(physiqueDto, Physique.class)),Physique.class);
    }

    @Override
    public List<PhysiqueDto> getALl() {
        return mapper.mapList(physiqueRepository.findAll(), PhysiqueDto.class);
    }

    @Override
    public PhysiqueDto getById(long id) {
        Physique physique=physiqueRepository.findById(id).get();
        return mapper.map(physique,PhysiqueDto.class);
    }

    @Override
    public void update(long id, PhysiqueDto physiqueDto ) {
        if(!physiqueRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        physiqueDto.setId(id);
        mapper.map(physiqueRepository.save(mapper.map(physiqueDto, Physique.class)), PhysiqueDto.class);
    }

    @Override
    public void delete(long id) {
        if(!physiqueRepository.existsById(id)) {
            throw new RuntimeException("action n'éxiste pas");
        }
        try {
            physiqueRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }
}
