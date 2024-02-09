package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.ObstacleDefuntsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ObstacleService {
	ObstacleDefunts add(ObstacleDefuntsDTO obstacleDefuntsDTO);
	List<ObstacleDefuntsDTO> getALl();
	ObstacleDefuntsDTO getById(long id);
	void update(long id,ObstacleDefuntsDTO obstacleDefuntsDTO);
	void delete(long id);
	Page<ObstacleDefuntsDTO> AllPagination(Pageable pageable);
}
