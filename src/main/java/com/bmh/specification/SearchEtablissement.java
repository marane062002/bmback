package com.bmh.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;
@Data@NoArgsConstructor@AllArgsConstructor
public class SearchEtablissement {
    Date dateFin;
    Date dateDebut;


}
