package com.park.server.demo.controller;

import com.park.server.demo.model.CategorieClient;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.model.Fournisseur;
import com.park.server.demo.model.Produit;
import com.park.server.demo.modelMapper.ChartWithDateMapModel;
import com.park.server.demo.repository.CategorieClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/categorieClient")
public class CategorieClientController {

    @Autowired
    private CategorieClientRepository categorieClientRepository;
    @GetMapping
    public List<CategorieClient> getCategorieClients(){
        return  categorieClientRepository.findAll();
    }

    @PostMapping
    public void addCategorieClient(@RequestBody CategorieClient categorieClient) {
        categorieClientRepository.save(categorieClient);}

    @PutMapping
    public void updateCategorieClient(@RequestBody CategorieClient categorieClient){
        categorieClientRepository.saveAndFlush(categorieClient);
    }
    @DeleteMapping("/{id}")
    public void deleteCategorieClient(@PathVariable Long id){
        categorieClientRepository.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public CategorieClient getCategorieClientById(@PathVariable Long id){

        return categorieClientRepository.findById(id).get();
    }

    @GetMapping("/getByName/{name}")
    public int getCategorieClientById(@PathVariable String name){
System.out.println("heeeeeeeeeeeeeeeeeeeere");
        CategorieClient categorieClient = categorieClientRepository.getCategorieClientByNom(name);

        if(categorieClient == null){
            return 0;
        }else{
            return 1;
        }
    }

}
