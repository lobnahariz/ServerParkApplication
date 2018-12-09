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
    @GetMapping("/NotPayed")
    public List<FactureDocumentModel> getAllBonFactureNonPaye(){
        List<FactureDocument> factureDocuments = factureRepository.getAllFactureNonPaye();

        return  this.mapper.convertToFactureDocumentModel(factureDocuments);
    }

    @GetMapping("/NotAllFactureWithNoStockUpdate")
    public List<FactureDocumentModel> getFactureWithNoStockUpdate(){
        List<FactureDocument> factureDocuments = factureRepository.getFactureWithNoStockUpdate();

        return  this.mapper.convertToFactureDocumentModel(factureDocuments);
    }
    @GetMapping("/getByRef/{ref}")
    public FactureDocumentModel getFactureById(@PathVariable String ref){

        FactureDocument factureDocument = factureRepository.getFactureDocumentByRef(ref);


        return  this.mapper.convertToFactureDocumentByIdModel(factureDocument);
    }
    @GetMapping("/getById/{id}")
    public FactureDocumentModel getFactureById(@PathVariable Long id){

        FactureDocument factureDocument = factureRepository.findById(id).get();


        return  this.mapper.convertToFactureDocumentByIdModel(factureDocument);
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
    public void updateFacture(@RequestBody FactureDocumentModel factureDocumentModel,
    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        FactureDocument factureDocument = this.mapper.convertToFactureDocumentEntity(factureDocumentModel);

        this.factureRepository.saveAndFlush(factureDocument);

    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        factureRepository.deleteById(id);
    }

}
