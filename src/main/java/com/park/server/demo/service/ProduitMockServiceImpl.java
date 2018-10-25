package com.park.server.demo.service;

import com.park.server.demo.model.Produit;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitMockServiceImpl implements IProduitService {

    private List<Produit> produits;

    public ProduitMockServiceImpl() {
        produits = new ArrayList<Produit>();
        produits.add(new Produit("Livre",50,20));
        produits.add(new Produit("xxx",50,20));
        produits.add(new Produit("yyy",50,20));
    }

    @Override
    public List<Produit> getProduits() {
        return produits;
    }

    @Override
    public void addProduit(Produit produit) {
        produits.add(produit);

    }

    @Override
    public void updateProduit(Produit produit) {
        produits.remove(produit);
        produits.add(produit);

    }

    @Override
    public void deleteProduit(String ref) {
        Produit produit1 = new Produit();
        produit1.setRef(ref);
        produits.remove(produit1);
    }
}
