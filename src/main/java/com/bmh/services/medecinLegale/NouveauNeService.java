package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.NouveauNe;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.NouveauNeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NouveauNeService {
	NouveauNe add(NouveauNeDTO nouveauNeDTO);
	List<NouveauNeDTO> getALl();
	NouveauNeDTO getById(long id);
	void update(long id,NouveauNeDTO nouveauNeDTO);
	void delete(long id);
	Page<NouveauNeDTO> AllPagination(Pageable pageable);
}
