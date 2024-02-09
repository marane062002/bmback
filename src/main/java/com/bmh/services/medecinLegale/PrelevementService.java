package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Origine;
import com.bmh.Models.medecinLegale.Prelevement;
import com.bmh.beans.medecinLegale.OrigineDTO;
import com.bmh.beans.medecinLegale.PrelevementDTO;

import java.util.List;

public interface PrelevementService {
	Prelevement add(PrelevementDTO 	prelevementDTO);
	List<PrelevementDTO> getALl();
	PrelevementDTO getById(long id);
	void update(long id,PrelevementDTO prelevementDTO);
	void delete(long id);
}
