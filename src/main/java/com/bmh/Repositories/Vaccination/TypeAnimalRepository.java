package com.bmh.Repositories.Vaccination;

import com.bmh.Models.vaccination.TypeAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAnimalRepository extends JpaRepository<TypeAnimal,Long> {
}
