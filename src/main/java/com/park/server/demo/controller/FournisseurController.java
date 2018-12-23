package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.Client;
import com.park.server.demo.model.Fournisseur;
import com.park.server.demo.modelMapper.FournisseurModel;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurController {

   /* @Autowired
    private IEnteteDocumentService enteteDocumentService;*/

   @Autowired
   private FournisseurRepository fournisseurRepository;
   private Mapper mapper;


    public FournisseurController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<FournisseurModel> getFournisseurs()
    {
        return  this.mapper.convertAllFournisseur();
    }

    @PostMapping
    public void addFournisseur(@RequestBody FournisseurModel fournisseur) {

        Fournisseur clientN = this.mapper.convertToFournisseurEntity(fournisseur);

        this.fournisseurRepository.save(clientN);

}

    @PutMapping
    public void updateFournisseur(@RequestBody FournisseurModel fournisseur){

        Fournisseur clientN = this.mapper.convertToFournisseurEntity(fournisseur);

        this.fournisseurRepository.saveAndFlush(clientN);
    }
    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id){
        fournisseurRepository.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public Fournisseur getFournisseurById(@PathVariable Long id){

        return fournisseurRepository.findById(id).get();
    }
}
