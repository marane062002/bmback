package com.bmh.services.impl.medecinLegale;

import com.bmh.Models.medecinLegale.HistoriqueDeces;
import com.bmh.Models.medecinLegale.HistoriqueObstacel;
import com.bmh.Repositories.medecinLegale.HistoriqueObstacleRepository;
import com.bmh.beans.medecinLegale.HistoriqueObstacleDTO;
import com.bmh.services.Mapper;
import com.bmh.services.medecinLegale.HistoriqueObstacleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueObstacleServiceImpl implements HistoriqueObstacleService {
    private final HistoriqueObstacleRepository repository;
    private Mapper mapper;

    public HistoriqueObstacleServiceImpl(HistoriqueObstacleRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public HistoriqueObstacel add(HistoriqueObstacleDTO historiqueObstacleDTO) {
        return mapper.map(repository.save(mapper.map(historiqueObstacleDTO, HistoriqueObstacel.class)),HistoriqueObstacel.class);
    }

    @Override
    public List<HistoriqueObstacel> findByObstacleDefuntsId(Long obstacleDefuntsId) {
        return mapper.mapList(repository.findByObstacleDefuntsId(obstacleDefuntsId), HistoriqueObstacel.class);
    }
}
