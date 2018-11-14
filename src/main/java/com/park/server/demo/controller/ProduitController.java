package com.park.server.demo.controller;

import com.park.server.demo.model.Produit;
import com.park.server.demo.service.IProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin
public class ProduitController {

    @Autowired
private IProduitService produitService;

    @GetMapping
    public List<Produit> getProduits(){
         return  produitService.getProduits();
    }

    @PostMapping
    public void addProduit(@RequestBody Produit produit) {
        produitService.addProduit(produit); }

    @PutMapping
    public void updateProduit(@RequestBody Produit produit){
        produitService.updateProduit(produit);
    }
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
    }
}
