package com.bmh.beans.controle_sanitaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SommeSaisieDestructionDTO {
    private Long Kg;
    private Long Litre;
    private Long Unite;
}
