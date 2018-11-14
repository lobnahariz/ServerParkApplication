package com.park.server.demo.service;

import com.park.server.demo.model.Produit;
import com.park.server.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProduitService implements  IProduitService {

    @Autowired
private ProduitRepository produitRepository;
    @Override
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    @Override
    public void addProduit(Produit produit) {
produitRepository.save(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        Produit produit = new Produit();
produit.setId(id);
produitRepository.delete(produit);
    }
}
