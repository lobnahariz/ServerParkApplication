package com.park.server.demo.controller;

import com.park.server.demo.model.CategorieClient;
import com.park.server.demo.model.CategorieProduit;
import com.park.server.demo.repository.CategorieClientRepository;
import com.park.server.demo.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorieProduit")
public class CategorieProduitController {

    @Autowired
    private CategorieProduitRepository categorieProduitRepository;
    @GetMapping
    public List<CategorieProduit> getCategorieProduits(){
        return  categorieProduitRepository.findAll();
    }

    @PostMapping
    public void addCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
        categorieProduitRepository.save(categorieProduit);}

    @PutMapping
    public void updateCategorieProduit(@RequestBody CategorieProduit categorieProduit){
        categorieProduitRepository.saveAndFlush(categorieProduit);
    }
    @DeleteMapping("/{id}")
    public void deleteCategorieProduit(@PathVariable Long id){
        categorieProduitRepository.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public CategorieProduit getCategorieProduitById(@PathVariable Long id){

        return categorieProduitRepository.findById(id).get();
    }
    @GetMapping("/getByName/{name}")
    public int getCategorieProduitById(@PathVariable String name){
        CategorieProduit categorieProduit = categorieProduitRepository.getCategorieProduitByNom(name);
System.out.println("laaa");
        if(categorieProduit == null){
            return 0;
        }else{
            return 1;
        }
    }
}
