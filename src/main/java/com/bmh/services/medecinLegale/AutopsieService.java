package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Autopsie;
import com.bmh.Models.medecinLegale.Prelevement;
import com.bmh.beans.medecinLegale.AutopsieDTO;
import com.bmh.beans.medecinLegale.PrelevementDTO;

import java.util.List;
import java.util.Map;

public interface AutopsieService {
	Autopsie add(AutopsieDTO autopsieDTO);
	List<AutopsieDTO> getALl();
	List<AutopsieDTO> getByIdObstacle(long id);
	AutopsieDTO getById(long id);
	void update(long id,AutopsieDTO autopsieDTO);
	void delete(long id);

	List<Map<String, Object>> getAutopsieStatistics();
}
