package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.Repositories.medecinLegale.HistoriqueDecesRepository;
import com.bmh.beans.medecinLegale.HistoriqueDecesDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.HistoriqueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {
    private final HistoriqueDecesRepository repository;
    private Mapper mapper;

    public HistoriqueServiceImpl(HistoriqueDecesRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public HistoriqueDeces add(HistoriqueDecesDTO historiqueDecesDTO) {
        return mapper.map(repository.save(mapper.map(historiqueDecesDTO, HistoriqueDeces.class)),HistoriqueDeces.class);
    }

    @Override
    public List<HistoriqueDeces> findByDecesNaturelId(Long decesNaturelId) {
        return mapper.mapList(repository.findByDecesNaturelId(decesNaturelId), HistoriqueDeces.class);
    }

}
