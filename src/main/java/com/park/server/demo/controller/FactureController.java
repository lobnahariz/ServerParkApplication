package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.modelMapper.BonDeLivraisonDocumentModel;
import com.park.server.demo.modelMapper.FactureDocumentModel;
import com.park.server.demo.repository.BonDeLivraisonRepository;
import com.park.server.demo.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {


    private Mapper mapper;

    @Autowired
    private FactureRepository factureRepository;

    public FactureController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<FactureDocumentModel> getAllBonFacture(){
        List<FactureDocument> factureDocuments = factureRepository.findAll();

        return  this.mapper.convertToFactureDocumentModel(factureDocuments);
    }

    @PostMapping
    public FactureDocument save(@RequestBody FactureDocumentModel factureDocumentModel,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        FactureDocument factureDocument = this.mapper.convertToFactureDocumentEntity(factureDocumentModel);

        this.factureRepository.save(factureDocument);

        return factureDocument;
    }

    @PutMapping
    public void updateFacture(@RequestBody FactureDocument factureDocument){
        factureRepository.save(factureDocument);
    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        factureRepository.deleteById(id);
    }

}
