package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.InformationSecesConstateur;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.InformationSecesConstateurDTO;

import java.util.List;

public interface InformationSecesConstateurService {
	InformationSecesConstateur add(InformationSecesConstateurDTO informationSecesConstateurDTO);
	List<InformationSecesConstateurDTO> getALl();
	InformationSecesConstateurDTO getById(long id);
	void update(long id,InformationSecesConstateurDTO informationSecesConstateurDTO);
	void delete(long id);
}
