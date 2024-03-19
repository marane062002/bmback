package com.bmh.specification;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Controleur;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import com.bmh.Models.medecinLegale.DecesNaturel;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class DecesSpecifications {
    public static Specification<DecesNaturel> hasDateDeces(LocalDate dateDeces) {
        return (root, query, criteriaBuilder) -> {
            if (dateDeces == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("dateDeces"), dateDeces.toString());
        };
    }

    public static Specification<DecesNaturel> hasArrondissement(Arrondissement arrondissement) {
        return (root, query, criteriaBuilder) -> {
            if (arrondissement == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("arrondissement"), arrondissement);
        };
    }

    public static Specification<DecesNaturel> hasStatusCadavre(StatusCadavre statusCadavre) {
        return (root, query, criteriaBuilder) -> {
            if (statusCadavre == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("statusCadavre"), statusCadavre);
        };
    }
}
