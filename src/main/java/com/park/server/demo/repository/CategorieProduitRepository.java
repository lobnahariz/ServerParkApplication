package com.park.server.demo.repository;

import com.park.server.demo.model.CategorieClient;
import com.park.server.demo.model.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit,Long> {
public CategorieProduit getCategorieProduitByNom(String nom);
}
