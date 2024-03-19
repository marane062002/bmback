package com.bmh.beans.medecinLegale;

import com.bmh.Models.medecinLegale.DecesNaturel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueDecesDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nouveauStatut;
    private DecesNaturel decesNaturel;
    @JsonFormat(shape = JsonFormat.Shape.STRING , timezone = "UTC")
    private Date updatedAt;
}
