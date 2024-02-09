package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Autopsie;
import com.bmh.Models.medecinLegale.Cadavre;
import com.bmh.beans.medecinLegale.AutopsieDTO;
import com.bmh.beans.medecinLegale.CadavreDTO;

import java.util.List;

public interface CadavreService {
	Cadavre add(CadavreDTO cadavreDTO);
	List<CadavreDTO> getALl();
	CadavreDTO getById(long id);
	void update(long id,CadavreDTO cadavreDTO);
	void delete(long id);
}
