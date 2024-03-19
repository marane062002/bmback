package com.bmh.Repositories.Controllers.Vaccination;

import com.bmh.Models.vaccination.InfosGenerales;
import com.bmh.beans.VaccinationDTO.InfosGeneralesDto;
import com.bmh.services.Vaccination.IinfosGeneralesService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class InfosGeneralesController {
    private final IinfosGeneralesService iinfosGeneralesService;
    private final ModelMapper mapper;

    public InfosGeneralesController(IinfosGeneralesService iinfosGeneralesService, ModelMapper mapper) {
        this.iinfosGeneralesService = iinfosGeneralesService;
        this.mapper = mapper;
    }

    @GetMapping("/paginate/{pageNo}/{pageSize}")
    public ResponseEntity<Page<InfosGeneralesDto>> getAllwithPaginate(
            @PathVariable int pageNo,
            @PathVariable int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<InfosGeneralesDto> page = iinfosGeneralesService.AllPagination(pageable);

        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<InfosGeneralesDto>> getAll(){
        List<InfosGeneralesDto> infosGeneralesDtos=iinfosGeneralesService.getALl();
        return new ResponseEntity<>(infosGeneralesDtos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<InfosGeneralesDto> create(
            @RequestPart(name = "generale") InfosGeneralesDto infosGeneralesDto) {
        InfosGenerales infosGenerales = iinfosGeneralesService.add(infosGeneralesDto);
        return new ResponseEntity<>(mapper.map(infosGenerales, InfosGeneralesDto.class), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<InfosGeneralesDto> getById(@PathVariable Long id) {
        InfosGeneralesDto infosGeneralesDto = iinfosGeneralesService.getById(id);
        return new ResponseEntity<>(infosGeneralesDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InfosGenerales> update(@PathVariable Long id,
                                       @RequestBody InfosGeneralesDto infosGeneralesDto){
        InfosGenerales infosGenerales = iinfosGeneralesService.update(id, infosGeneralesDto);
        return new ResponseEntity<>(infosGenerales,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iinfosGeneralesService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
