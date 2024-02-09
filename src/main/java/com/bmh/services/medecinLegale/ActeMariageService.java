package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.ActeMariage;
import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.beans.medecinLegale.ActeMariageDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;

import java.util.List;

public interface ActeMariageService {
	ActeMariage add(ActeMariageDTO acteMariageDTO);
	List<ActeMariageDTO> getALl();
	ActeMariageDTO getById(long id);
	void update(long id,ActeMariageDTO acteMariageDTO);
	void delete(long id);
}
