package com.bmh.Repositories;

import com.bmh.Models.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceRepository extends JpaRepository<Type,Long>, JpaSpecificationExecutor<Type> {
	/*Page<Type> findByLibelleAndDescription(String libelle,String description,Pageable p);
	Page<Type> findAll(Pageable p);*/
}
