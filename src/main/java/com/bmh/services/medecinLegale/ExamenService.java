package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.EntermentObstacle;
import com.bmh.Models.medecinLegale.Examen;
import com.bmh.beans.medecinLegale.EnterrementObstacleDTO;
import com.bmh.beans.medecinLegale.ExamenDTO;

import java.util.List;
import java.util.Map;

public interface ExamenService {
	Examen add(ExamenDTO examenDTO);
	List<ExamenDTO> getALl();
	List<ExamenDTO> getByIdObstacle(long id);
	ExamenDTO getById(long id);
	void update(long id,ExamenDTO examenDTO);
	void delete(long id);

	List<Map<String, Object>> getExamenStatistics();
}
