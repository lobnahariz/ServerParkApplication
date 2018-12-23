package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.model.Produit;
import com.park.server.demo.model.Reclamation;
import com.park.server.demo.modelMapper.ChartWithDateMapModel;
import com.park.server.demo.modelMapper.ProduitModel;
import com.park.server.demo.modelMapper.ReclamationModel;
import com.park.server.demo.repository.FactureRepository;
import com.park.server.demo.repository.ProduitRepository;
import com.park.server.demo.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ReclamationController {
    private Mapper mapper;
    @Autowired
    private ReclamationRepository reclamationRepository;



    public ReclamationController(Mapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/api/reclamation")
    public List<ReclamationModel> getReclamations(){

        return  this.mapper.convertAllReclamation();
    }


    @PostMapping("/api/reclamation")
    public void addReclamation(@RequestBody ReclamationModel reclamationModel) {

        Reclamation reclamation = this.mapper.convertToReclamationEntity(reclamationModel);

        this.reclamationRepository.save(reclamation);

         }

    @PutMapping("/api/reclamation")
    public void updateReclamation(@RequestBody ReclamationModel reclamationModel){

        Reclamation reclamation = this.mapper.convertToReclamationEntity(reclamationModel);

        this.reclamationRepository.saveAndFlush(reclamation);
    }
    @DeleteMapping("/api/reclamation/{id}")
    public void deleteReclamation(@PathVariable Long id){
        reclamationRepository.deleteById(id);
    }

}
