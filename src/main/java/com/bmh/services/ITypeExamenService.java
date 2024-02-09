package com.bmh.services;

import com.bmh.Models.TypeExamen;
import com.bmh.beans.TypeExamenDTO;

import java.util.List;

public interface ITypeExamenService {
	TypeExamen add(TypeExamenDTO typeExamenDTO);
	List<TypeExamenDTO> getAll();
	void delete(long id);
	void update(long id,TypeExamenDTO typeExamenDTO);

	TypeExamenDTO getById(long id);
}
