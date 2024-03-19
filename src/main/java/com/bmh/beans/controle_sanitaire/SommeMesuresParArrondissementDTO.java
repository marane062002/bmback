package com.bmh.beans.controle_sanitaire;

import com.bmh.Models.Arrondissement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SommeMesuresParArrondissementDTO {
    private Long Prelevements;
    private Long MiseDemeurs;
    private Long AvertissementOrale;
    private Long ArretActivite;
    private Long SaisieDestructions;
}
