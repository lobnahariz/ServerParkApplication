package com.park.server.demo.controller;

import com.park.server.demo.model.Produit;
import com.park.server.demo.service.IProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.prefs.Preferences;

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
        System.out.println("ajouuuuuuuuut");
        produitService.addProduit(produit); }

    @PutMapping
    public void updateProduit(@RequestBody Produit produit){
        produitService.updateProduit(produit);
    }
    @DeleteMapping("/{ref}")
    public void deleteProduit(@PathVariable String ref){
        produitService.deleteProduit(ref);
    }
}
