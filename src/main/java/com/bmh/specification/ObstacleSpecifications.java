package com.bmh.specification;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Enum.StatusCadavre;
import com.bmh.Models.medecinLegale.ObstacleDefunts;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class ObstacleSpecifications {
    public static Specification<ObstacleDefunts> hasDateDeces(LocalDate dateDeces) {
        return (root, query, criteriaBuilder) -> {
            if (dateDeces == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("dateDeces"), dateDeces);
        };
    }

    public static Specification<ObstacleDefunts> hasArrondissement(Arrondissement arrondissement) {
        return (root, query, criteriaBuilder) -> {
            if (arrondissement == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("arrondissement"), arrondissement);
        };
    }

    public static Specification<ObstacleDefunts> hasStatusCadavre(StatusCadavre statusCadavre) {
        return (root, query, criteriaBuilder) -> {
            if (statusCadavre == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("statusCadavre"), statusCadavre);
        };
    }
}
