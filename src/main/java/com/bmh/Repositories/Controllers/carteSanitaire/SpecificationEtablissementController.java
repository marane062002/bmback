package com.bmh.Repositories.Controllers.carteSanitaire;

import com.bmh.Models.controle_sanitaire.Etablissement;
import com.bmh.services.impl.carteSanitaire.SpecificationServiceImpl;
import com.bmh.specification.SearchEtablissement;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/" +
        "")
public class SpecificationEtablissementController {
    private final SpecificationServiceImpl service;

    public SpecificationEtablissementController(SpecificationServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public List<Etablissement> specification(@RequestParam Date dateDebut, @RequestParam Date dateFin) {
//        PageRequest pageRequest = PageRequest.of(page,size);
        SearchEtablissement searchCriteria = new SearchEtablissement();
        searchCriteria.setDateDebut(dateDebut);
        searchCriteria.setDateFin(dateFin);
        List<Etablissement> pageResult = this.service.findSpecification(searchCriteria);
        return pageResult;


    }
}
