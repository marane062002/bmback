package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Fourgon;
import com.bmh.Models.medecinLegale.Organisme;
import com.bmh.beans.medecinLegale.FourgonDTO;
import com.bmh.beans.medecinLegale.OrganismeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrganismeService {
	Organisme add(OrganismeDTO organismeDTO);
	List<OrganismeDTO> getALl();
	OrganismeDTO getById(long id);
	void update(long id,OrganismeDTO organismeDTO);
	void delete(long id);

	Page<OrganismeDTO> AllPagination(Pageable pageable);
}
