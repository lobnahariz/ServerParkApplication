package com.park.server.demo.service;



import com.park.server.demo.model.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> getProduits();

    void addProduit(Produit produit);
    void updateProduit(Produit produit);
    void deleteProduit(Long id);
}
