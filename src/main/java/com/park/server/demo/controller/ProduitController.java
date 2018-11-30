package com.park.server.demo.controller;

import com.park.server.demo.model.Produit;
import com.park.server.demo.repository.ProduitRepository;
import com.park.server.demo.service.IProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProduitController {

    @Autowired
private ProduitRepository produitRepository;

    @GetMapping("/api/produit")
    public List<Produit> getProduits(){
         return  produitRepository.findAll();
    }


    @GetMapping("/api/produit/getByRef/{ref}")
    public Produit getProduit(@PathVariable String ref){
System.out.println("Ref :    "+ref);
        return  produitRepository.getProduitByRef(ref);
    }


    @PostMapping("/api/produit")
    public void addProduit(@RequestBody Produit produit) {
        produitRepository.save(produit); }

    @PutMapping("/api/produit")
    public void updateProduit(@RequestBody Produit produit){
        produitRepository.save(produit);
    }
    @DeleteMapping("/api/produit/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitRepository.deleteById(id);
    }
}
