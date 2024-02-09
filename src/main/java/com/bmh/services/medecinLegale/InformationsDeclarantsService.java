package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.InformationsDeclarants;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.InformationsDeclarantsDTO;

import java.util.List;

public interface InformationsDeclarantsService {
	InformationsDeclarants add(InformationsDeclarantsDTO informationsDeclarantsDTO);
	List<InformationsDeclarantsDTO> getALl();
	InformationsDeclarantsDTO getById(long id);
	void update(long id,InformationsDeclarantsDTO informationsDeclarantsDTO);
	void delete(long id);
}
