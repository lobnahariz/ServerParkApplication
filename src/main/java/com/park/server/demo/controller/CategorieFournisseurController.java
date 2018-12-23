package com.park.server.demo.controller;

import com.park.server.demo.model.CategorieClient;
import com.park.server.demo.model.CategorieFournisseur;
import com.park.server.demo.repository.CategorieClientRepository;
import com.park.server.demo.repository.CategorieFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorieFournisseur")
public class CategorieFournisseurController {

    @Autowired
    private CategorieFournisseurRepository categorieFournisseurRepository;
    @GetMapping
    public List<CategorieFournisseur> getCategorieFournisseurs(){
        return  categorieFournisseurRepository.findAll();
    }

    @PostMapping
    public void addCategorieFournisseur(@RequestBody CategorieFournisseur categorieClient) {
        categorieFournisseurRepository.save(categorieClient);}

    @PutMapping
    public void updateCategorieFournisseur(@RequestBody CategorieFournisseur categorieClient){
        categorieFournisseurRepository.saveAndFlush(categorieClient);
    }
    @DeleteMapping("/{id}")
    public void deleteCategorieFournisseur(@PathVariable Long id){
        categorieFournisseurRepository.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public CategorieFournisseur getCategorieFournisseurById(@PathVariable Long id){

        return categorieFournisseurRepository.findById(id).get();
    }
    @GetMapping("/getByName/{name}")
    public int getCategorieFournisseurById(@PathVariable String name){
        CategorieFournisseur categorieFournisseur = categorieFournisseurRepository.getCategorieFournisseurByNom(name);

        if(categorieFournisseur == null){
            return 0;
        }else{
            return 1;
        }
    }
}
