package com.bmh.Repositories;


import com.bmh.Models.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends CrudRepository<Test, Long>{

	
}
