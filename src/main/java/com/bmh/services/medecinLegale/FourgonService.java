package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.FourgonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FourgonService {
	Fourgon add(FourgonDTO fourgonDTO, MultipartFile pcj);
	List<FourgonDTO> getALl();
	FourgonDTO getById(long id);
	void update(long id,FourgonDTO fourgonDTO, MultipartFile pcj);
	void delete(long id);

	Page<FourgonDTO> AllPagination(Pageable pageable);
}
