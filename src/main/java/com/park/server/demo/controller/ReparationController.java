package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.DevisDocument;
import com.park.server.demo.model.ReparationDocument;
import com.park.server.demo.modelMapper.DevisDocumentModel;
import com.park.server.demo.modelMapper.ReparationModel;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.DevisRepository;
import com.park.server.demo.repository.FournisseurRepository;
import com.park.server.demo.repository.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/reparation")
public class ReparationController {

    private Mapper mapper;

    @Autowired
    private ReparationRepository reparationRepository;

    public ReparationController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<ReparationDocument> getAllReparations(){
        return  reparationRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ReparationModel getReparationById(@PathVariable Long id){

        ReparationDocument reparationDocument = reparationRepository.findById(id).get();


        return  this.mapper.convertToReparationDocumentModel(reparationDocument);
    }


    @PostMapping
    public ReparationDocument save(@RequestBody ReparationModel reparationModel,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        ReparationDocument reparationDocument = this.mapper.convertToReparationDocumentEntity(reparationModel);

        this.reparationRepository.save(reparationDocument);

        return reparationDocument;
    }

    @PutMapping
    public void updateReparation(@RequestBody ReparationModel reparationModel, BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        ReparationDocument reparationDocument = this.mapper.convertToReparationDocumentEntity(reparationModel);

        this.reparationRepository.saveAndFlush(reparationDocument);

    }
    @DeleteMapping("/{id}")
    public void deleteReparation(@PathVariable Long id){
        reparationRepository.deleteById(id);
    }

}
