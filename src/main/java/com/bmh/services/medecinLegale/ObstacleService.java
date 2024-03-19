package com.bmh.services.medecinLegale;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.ObstacleDefuntsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface ObstacleService {
	ObstacleDefunts add(ObstacleDefuntsDTO obstacleDefuntsDTO);
	List<ObstacleDefuntsDTO> getALl();
	ObstacleDefuntsDTO getById(long id);
	void update(long id,ObstacleDefuntsDTO obstacleDefuntsDTO);
	void delete(long id);
	Page<ObstacleDefuntsDTO> AllPagination(Pageable pageable);

	List<Map<String, Object>> countDefuntsByNationaliteAndSexe();

	Page<ObstacleDefuntsDTO> getAllPaginationWithFilter(LocalDate dateDeces, Arrondissement arrondissement, StatusCadavre statusCadavre, Pageable pageable);
}
