package com.bmh.services.impl;

import com.bmh.Models.Conducteur;
import com.bmh.Models.Controleur;
import com.bmh.Repositories.ControleurRepository;
import com.bmh.beans.ConducteurDTO;
import com.bmh.beans.ControleurDTO;
import com.bmh.services.ControleurService;
import com.bmh.services.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ControleurServiceImpl implements ControleurService {
    private final ControleurRepository repository;
    private final Mapper mapper;

    public ControleurServiceImpl(ControleurRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Controleur create(ControleurDTO controleurDTO) {
        return mapper.map(repository.save(mapper.map(controleurDTO, Controleur.class)),Controleur.class);
    }

    @Override
    public List<ControleurDTO> getAll() {
        return mapper.mapList(repository.findAll(), ControleurDTO.class);
    }

    @Override
    public ControleurDTO getById(long id) {
        Controleur controleur=repository.findById(id).get();
        return mapper.map(controleur,ControleurDTO.class);
    }

    @Override
    public void update(long id, ControleurDTO controleurDTO) {
        Optional<Controleur> controleur=repository.findById(id);
        if(controleur.isPresent()){
            Controleur exestingControleur=controleur.get();
            exestingControleur.setNom(controleurDTO.getNom());
            exestingControleur.setPrenom(controleurDTO.getPrenom());
            exestingControleur.setCin(controleurDTO.getCin());
            exestingControleur.setTel(controleurDTO.getTel());
            repository.save(exestingControleur);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Controleur> controleur=repository.findById(id);
        if(controleur.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("controleur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
