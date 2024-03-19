package com.bmh.specification;
import com.bmh.Models.Arrondissement;
import com.bmh.Models.Controleur;
import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import org.springframework.data.jpa.domain.Specification;


public class EtabSpec {
    public static Specification<Etablissement> hasNatureEtablissement(NatureEtablissement nature) {
        return (root, query, criteriaBuilder) -> {
            if (nature != null) {
                return criteriaBuilder.equal(root.get("natureEtablissement"), nature);
            }
            return null;
        };
    }

    public static Specification<Etablissement> hasEtatHygiene(EtatHygiene etatHygiene) {
        return (root, query, criteriaBuilder) -> {
            if (etatHygiene != null) {
                return criteriaBuilder.equal(root.get("etatHygiene"), etatHygiene);
            }
            return null;
        };
    }

    public static Specification<Etablissement> hasArrondissement(Arrondissement arrondissement) {
        return (root, query, criteriaBuilder) -> {
            if (arrondissement != null) {
                return criteriaBuilder.equal(root.get("arrondissement"), arrondissement);
            }
            return null;
        };
    }

    public static Specification<Etablissement> hasControleur(Controleur controleur) {
        return (root, query, criteriaBuilder) -> {
            if (controleur != null) {
                return criteriaBuilder.equal(root.get("controleur"), controleur);
            }
            return null;
        };
    }
}

