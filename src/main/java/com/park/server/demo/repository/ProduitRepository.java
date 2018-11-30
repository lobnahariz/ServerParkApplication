package com.park.server.demo.repository;

import com.park.server.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    public Produit getProduitByRef(String ref);
}
