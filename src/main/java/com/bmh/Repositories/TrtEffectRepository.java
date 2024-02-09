package com.bmh.Repositories;

import com.bmh.Models.TraitEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrtEffectRepository extends JpaRepository<TraitEffect,Long> {
}
