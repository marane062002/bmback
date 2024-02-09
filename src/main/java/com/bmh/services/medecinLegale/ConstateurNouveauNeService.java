package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.ActeMariage;
import com.bmh.Models.medecinLegale.ConstateurNouveauNe;
import com.bmh.beans.medecinLegale.ActeMariageDTO;
import com.bmh.beans.medecinLegale.ConstateurNouveauNeDTO;

import java.util.List;

public interface ConstateurNouveauNeService {
	ConstateurNouveauNe add(ConstateurNouveauNeDTO constateurNouveauNeDTO);
	List<ConstateurNouveauNeDTO> getALl();
	ConstateurNouveauNeDTO getById(long id);
	void update(long id,ConstateurNouveauNeDTO constateurNouveauNeDTO);
	void delete(long id);
}
