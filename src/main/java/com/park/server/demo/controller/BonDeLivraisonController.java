package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.DevisDocument;
import com.park.server.demo.modelMapper.BonDeLivraisonDocumentModel;
import com.park.server.demo.modelMapper.DevisDocumentModel;
import com.park.server.demo.repository.BonDeLivraisonRepository;
import com.park.server.demo.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/bonDeLivraison")
@CrossOrigin
public class BonDeLivraisonController {

   /* @Autowired
    private IEnteteDocumentService enteteDocumentService;*/

  // private EnteteDocumentRepository enteteDocumentRepository;
    private Mapper mapper;

    @Autowired
    private BonDeLivraisonRepository bonDeLivraisonRepository;

    public BonDeLivraisonController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<BonLivraisonDocument> getAllBonDeLivraison(){
        return  bonDeLivraisonRepository.findAll();
    }

    @PostMapping
    public BonLivraisonDocument save(@RequestBody BonDeLivraisonDocumentModel bonDeLivraisonDocumentModel,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        BonLivraisonDocument bonLivraisonDocument = this.mapper.convertToBonDeLivraisonDocumentEntity(bonDeLivraisonDocumentModel);

        this.bonDeLivraisonRepository.save(bonLivraisonDocument);

        return bonLivraisonDocument;
    }

    @PutMapping
    public void updateBonLivraison(@RequestBody BonLivraisonDocument bonLivraisonDocument){
        bonDeLivraisonRepository.save(bonLivraisonDocument);
    }
    @DeleteMapping("/{id}")
    public void deleteBonLivraison(@PathVariable Long id){
        bonDeLivraisonRepository.deleteById(id);
    }

}