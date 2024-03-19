package com.bmh.services;

import com.bmh.Models.Conducteur;
import com.bmh.Models.Controleur;
import com.bmh.Models.controle_sanitaire.Agent;
import com.bmh.beans.ConducteurDTO;
import com.bmh.beans.ControleurDTO;
import com.bmh.beans.controle_sanitaire.AgentDTO;

import java.util.List;

public interface ControleurService {
    Controleur create(ControleurDTO controleurDTO);
    List<ControleurDTO> getAll();
    ControleurDTO getById(long id);
    void update(long id,ControleurDTO controleurDTO);
    void delete(long id);
}
