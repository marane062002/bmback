package com.bmh.services.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Controleur;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.beans.controle_sanitaire.AgentDTO;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IDecesNaturelService {
	DecesNaturel add(DecesNaturelDTO decesNaturelDTO);
	List<DecesNaturelDTO> getALl();
	DecesNaturelDTO getById(long id);
	void update(long id,DecesNaturelDTO decesNaturelDTO);
	void delete(long id);

	List<Map<String, Object>> countDeathsByConstaterAndSexe();
	List<Map<String, Object>> countDeathsByArrondissementAndSexe();
	Page<DecesNaturelDTO> AllPagination(Pageable pageable);

	Page<DecesNaturelDTO> getAllPaginationWithFilter(LocalDate dateDeces, Arrondissement arrondissement, StatusCadavre statusCadavre, Pageable pageable);
}
