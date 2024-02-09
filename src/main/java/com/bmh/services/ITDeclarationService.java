package com.bmh.services;

import com.bmh.Models.TDeclaration;
import com.bmh.beans.TDeclarationDTO;

import java.util.List;

public interface ITDeclarationService {
	TDeclaration add(TDeclarationDTO tDeclarationDTO);
	List<TDeclarationDTO> getALl();
	TDeclarationDTO getById(long id);
	void update(long id,TDeclarationDTO tDeclarationDTO);
	void delete(long id);
}
