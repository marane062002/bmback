package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.ActeMariage;
import com.bmh.Models.medecinLegale.EntermentObstacle;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.beans.medecinLegale.ActeMariageDTO;
import com.bmh.beans.medecinLegale.EnterrementObstacleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnterremementObstacleService {
	EntermentObstacle add(EnterrementObstacleDTO enterrementObstacleDTO);
	List<EnterrementObstacleDTO> getALl();
	EnterrementObstacleDTO getById(long id);
	void update(long id,EnterrementObstacleDTO enterrementObstacleDTO);
	void delete(long id);


}
