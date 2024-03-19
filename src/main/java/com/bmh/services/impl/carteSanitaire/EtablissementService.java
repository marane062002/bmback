package com.bmh.services.impl.carteSanitaire;

import com.bmh.Models.Arrondissement;
import com.bmh.Models.Controleur;
import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.Models.controle_sanitaire.EtatHygiene;
import com.bmh.Models.controle_sanitaire.NatureEtablissement;
import com.bmh.Models.controle_sanitaire.Programmes;
import com.bmh.Repositories.carteSanitaire.EtablissementRepository;
import com.bmh.Repositories.carteSanitaire.ProgrammeRepository;
import com.bmh.beans.controle_sanitaire.EtablissementDTO;
import com.bmh.beans.controle_sanitaire.ProgrammeDto;
import com.bmh.services.Mapper;
import com.bmh.services.carteSanitaire.IEtablissementService;
import com.bmh.specification.EtabSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementService implements IEtablissementService {
   private final EtablissementRepository etablissementRepository;
   private final Mapper mapper;

    public EtablissementService(EtablissementRepository etablissementRepository, Mapper mapper) {
        this.etablissementRepository = etablissementRepository;
        this.mapper = mapper;
    }


    @Override
    public Etablissement add(EtablissementDTO etablissementDTO) {
        return mapper.map(etablissementRepository.save(mapper.map(etablissementDTO, Etablissement.class)),Etablissement.class);
    }

    @Override
    public List<EtablissementDTO> getALl() {
        return mapper.mapList(etablissementRepository.findAll(), EtablissementDTO.class);
    }


    @Override
    public EtablissementDTO getById(long id) {
        Etablissement etablissement=etablissementRepository.findById(id).get();
        return mapper.map(etablissement,EtablissementDTO.class);
    }

//    @Override
//    public Page<EtablissementDTO> AllPagination(Pageable pageable){
//        Page<EtablissementDTO> etablissementDTOS=etablissementRepository.findAll(pageable).map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//        return etablissementRepository.findAll(pageable).map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//    };

//    @Override
//    public Page<EtablissementDTO> getAllPaginationWithFilter(String natureEtablissement, Pageable pageable) {
//        if (natureEtablissement != null && !natureEtablissement.isEmpty()) {
//            return etablissementRepository.findByNatureEtablissement(natureEtablissement, pageable)
//                    .map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//        } else {
//            return etablissementRepository.findAll(pageable)
//                    .map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//        }
//    }

//
//    @Override
//    public Page<EtablissementDTO> getAllPaginationWithFilter(NatureEtablissement nature, EtatHygiene etatHygiene, Pageable pageable) {
//        if (nature != null ) {
//            return etablissementRepository.findByNatureEtablissement(nature, pageable)
//                    .map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//        }
//
//        else {
//            return etablissementRepository.findAll(pageable)
//                    .map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//        }
//    }









    @Override
    public void update(long id, EtablissementDTO etablissementDTO ) {
       /* Optional<Etablissement> etablissementOptional=etablissementRepository.findById(id);
        if(etablissementOptional.isPresent()){
            Etablissement etablissement=etablissementOptional.get();
            etablissement.setDescription(etablissementDTO.getDescription());
            etablissement.setActivite(etablissementDTO.getActivite());
            etablissement.setTel(etablissementDTO.getTel());
            etablissement.setFax(etablissementDTO.getFax());
            etablissement.setIfiscal(etablissementDTO.getIfiscal());
            etablissement.setAdresse(etablissementDTO.getAdresse());
            etablissement.setPersonne(etablissementDTO.getPersonne());
            etablissement.setNomProp(etablissementDTO.getNomProp());
            etablissement.setPrenomProp(etablissementDTO.getPrenomProp());
            etablissement.setCinPro(etablissementDTO.getCinPro());
            etablissement.setTelProp(etablissementDTO.getTelProp());
            etablissement.setNomGerant(etablissementDTO.getNomGerant());
            etablissement.setPrenomGerant(etablissementDTO.getPrenomGerant());
            etablissement.setCinGerant(etablissementDTO.getCinGerant());
            etablissement.setTelGerant(etablissementDTO.getTelGerant());
            etablissement.setRs(etablissementDTO.getRs());
            etablissement.setRc(etablissementDTO.getRc());
            etablissement.setNom(etablissementDTO.getNom());
            etablissement.setPrenom(etablissementDTO.getPrenom());
            etablissement.setCin(etablissementDTO.getCin());
            etablissementRepository.save(etablissement);
        }*/

        if(!etablissementRepository.existsById(id)) {
            throw new RuntimeException("RESOURCE_NOT_FOUND");
        }
        etablissementDTO.setId(id);
        mapper.map(etablissementRepository.save(mapper.map(etablissementDTO, Etablissement.class)), EtablissementDTO.class);
    }

    @Override
    public void delete(long id) {
        if(!etablissementRepository.existsById(id)) {
            throw new RuntimeException("établissement n'éxiste pas");
        }
        try {
            etablissementRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException (e.getMessage());
        }
    }

    @Override
    public Page<EtablissementDTO> getPaginationFilterWithHygiene(String hygiene, Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<EtablissementDTO> getAllPaginationWithFilter(NatureEtablissement nature, EtatHygiene etatHygiene, Pageable pageable) {
//        Specification<Etablissement> spec = Specification.where(null);
//        if (nature != null) {
//            spec = spec.and(EtabSpec.hasNatureEtablissement(nature));
//        }
//        if (etatHygiene != null) {
//            spec = spec.and(EtabSpec.hasEtatHygiene(etatHygiene));
//        }
//        return etablissementRepository.findAll(spec, pageable)
//                .map(etabs -> mapper.map(etabs, EtablissementDTO.class));
//    }



    @Override
    public Page<EtablissementDTO> getAllPaginationWithFilter(NatureEtablissement nature, EtatHygiene etatHygiene, Arrondissement arrondissement, Controleur controleur, Pageable pageable) {
        Specification<Etablissement> spec = Specification.where(null);
        if (nature != null) {
            spec = spec.and(EtabSpec.hasNatureEtablissement(nature));
        }
        if (etatHygiene != null) {
            spec = spec.and(EtabSpec.hasEtatHygiene(etatHygiene));
        }
        if (arrondissement != null) {
            spec = spec.and(EtabSpec.hasArrondissement(arrondissement));
        }
        if (controleur != null) {
            spec = spec.and(EtabSpec.hasControleur(controleur));
        }
        return etablissementRepository.findAll(spec, pageable)
                .map(etabs -> mapper.map(etabs, EtablissementDTO.class));
    }

}
