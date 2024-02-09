package com.bmh.services.medecinLegale;

import com.bmh.Models.controle_sanitaire.cartesanitaire.Employeur;
import com.bmh.Models.medecinLegale.DecesNaturel;
import com.bmh.Models.medecinLegale.EntrementInhumation;
import com.bmh.beans.controle_sanitaire.EmployeurDto;
import com.bmh.beans.medecinLegale.DecesNaturelDTO;
import com.bmh.beans.medecinLegale.EntrementInhumationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EntrementInhumationService {
	EntrementInhumation add(EntrementInhumationDTO entrementInhumationDTO, MultipartFile pieceJointe);
	List<EntrementInhumationDTO> getALl();
	EntrementInhumationDTO getById(long id);
	void update(long id,EntrementInhumationDTO entrementInhumationDTO, MultipartFile pieceJointe);
	void delete(long id);
	Page<EntrementInhumationDTO> AllPagination(Pageable pageable);

}
