package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.SageFemme;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.SageFemmeDTO;

import java.util.List;

public interface SageFemmeService {
	SageFemme add(SageFemmeDTO sageFemmeDTO);
	List<SageFemmeDTO> getALl();
	SageFemmeDTO getById(long id);
	void update(long id,SageFemmeDTO sageFemmeDTO);
	void delete(long id);
}
