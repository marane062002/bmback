package com.bmh.services;

import com.bmh.Models.Type;
import com.bmh.beans.TypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterfaceService<T> {
    void add(T t);
    void update(T t,long id);
    void delete(long id);
    List<TypeDto> getAll();
    T getById(long id);
	//Page<Type> getTypeByLibelleAndDescription(String libelle,String description,Pageable p);


}
