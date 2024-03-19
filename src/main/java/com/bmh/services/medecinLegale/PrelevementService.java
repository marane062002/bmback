package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Origine;
import com.bmh.Models.medecinLegale.Prelevement;
import com.bmh.beans.medecinLegale.ExamenDTO;
import com.bmh.beans.medecinLegale.OrigineDTO;
import com.bmh.beans.medecinLegale.PrelevementDTO;

import java.util.List;
import java.util.Map;

public interface PrelevementService {
	Prelevement add(PrelevementDTO 	prelevementDTO);
	List<PrelevementDTO> getALl();

	List<PrelevementDTO> getByIdObstacle(long id);
	PrelevementDTO getById(long id);
	void update(long id,PrelevementDTO prelevementDTO);
	void delete(long id);

	List<Map<String, Object>> countPrelevementsBySexeAndAnalyseType();
}
