package com.bmh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    private String tel;
}
