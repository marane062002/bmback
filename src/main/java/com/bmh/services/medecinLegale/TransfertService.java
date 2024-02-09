package com.bmh.services.medecinLegale;

import com.bmh.Models.medecinLegale.Prelevement;
import com.bmh.Models.medecinLegale.Transfert;
import com.bmh.beans.medecinLegale.PrelevementDTO;
import com.bmh.beans.medecinLegale.TransfertDTO;

import java.util.List;

public interface TransfertService {
	Transfert add(TransfertDTO transfertDTO);
	List<TransfertDTO> getALl();
	TransfertDTO getById(long id);
	void update(long id,TransfertDTO transfertDTO);
	void delete(long id);
}
