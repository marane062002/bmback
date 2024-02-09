package com.bmh.services.medecinLegale;

import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDecesNaturelService {
	DecesNaturel add(DecesNaturelDTO decesNaturelDTO);
	List<DecesNaturelDTO> getALl();
	DecesNaturelDTO getById(long id);
	void update(long id,DecesNaturelDTO decesNaturelDTO);
	void delete(long id);
	Page<DecesNaturelDTO> AllPagination(Pageable pageable);
}
