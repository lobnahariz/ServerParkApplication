package com.park.server.demo.controller;

import com.park.server.demo.model.Produit;
import com.park.server.demo.service.IProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProduitController {

    @Autowired
private IProduitService produitService;

    @GetMapping("/api/produit")
    public List<Produit> getProduits(){
         return  produitService.getProduits();
    }

    @PostMapping("/api/produit")
    public void addProduit(@RequestBody Produit produit) {
        produitService.addProduit(produit); }

    @PutMapping("/api/produit")
    public void updateProduit(@RequestBody Produit produit){
        produitService.updateProduit(produit);
    }
    @DeleteMapping("/api/produit/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
    }
}
