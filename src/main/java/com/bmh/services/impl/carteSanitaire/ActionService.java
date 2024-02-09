package com.bmh.services.impl.carteSanitaire;
import com.bmh.Models.controle_sanitaire.Action;

import com.bmh.Repositories.carteSanitaire.ActionRepository;
import com.bmh.beans.controle_sanitaire.ActionDto;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IActionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ActionService implements IActionService {

    private final ActionRepository actionRepository;
    private Mapper mapper;

    public ActionService(ActionRepository actionRepository, Mapper mapper) {
        this.actionRepository = actionRepository;
        this.mapper = mapper;
    }

    @Override
    public Action add(ActionDto actionDto) {
        return mapper.map(actionRepository.save(mapper.map(actionDto, Action.class)),Action.class);
    }
    @Override
    public Page<ActionDto> AllPagination(Pageable pageable){
        return actionRepository.findAll(pageable).map(action -> mapper.map(action, ActionDto.class));
    };
    @Override
    public List<ActionDto> getALl() {
        return mapper.mapList(actionRepository.findAll(), ActionDto.class);
    }

    @Override
    public ActionDto getById(long id) {
        Action action=actionRepository.findById(id).get();
        return mapper.map(action,ActionDto.class);
    }

    @Override
    public void update(long id, ActionDto actionDto ) {
        if(!actionRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        actionDto.setId(id);
        mapper.map(actionRepository.save(mapper.map(actionDto, Action.class)), ActionDto.class);
    }

    @Override
    public void delete(long id) {
        if(!actionRepository.existsById(id)) {
            throw new RuntimeException("action n'éxiste pas");
        }
        try {
            actionRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }
}
