package com.bmh.services;

import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface IAgentService {
	Agent add(AgentDTO agentDTO);
	List<AgentDTO> getALl();
	AgentDTO getById(long id);
	void update(long id,AgentDTO agentDTO);
	void delete(long id);
}
