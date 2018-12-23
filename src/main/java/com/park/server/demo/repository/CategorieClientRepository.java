package com.park.server.demo.repository;

import com.park.server.demo.model.CategorieClient;
import com.park.server.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategorieClientRepository extends JpaRepository<CategorieClient,Long> {
public CategorieClient getCategorieClientByNom(String nom);
}
