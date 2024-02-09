package com.bmh.services;

import com.bmh.Models.TraitEffect;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.TraitEffectDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface ITraitEffectService {
	TraitEffect add(TraitEffectDTO traitEffectDTO);
	List<TraitEffectDTO> getALl();
	TraitEffectDTO getById(long id);
	void update(long id,TraitEffectDTO traitEffectDTO);
	void delete(long id);
}
