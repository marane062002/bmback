package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Morgue;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import com.bmh.beans.medecinLegale.MorgueDTO;
import com.bmh.beans.medecinLegale.ObstacleDefuntsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MorgueService {
	Morgue add(MorgueDTO morgueDTO);
	List<MorgueDTO> getALl();
	MorgueDTO getById(long id);
	void update(long id, MorgueDTO morgueDTO);
	void delete(long id);
	Page<MorgueDTO> AllPagination(Pageable pageable);
}
