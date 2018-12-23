package com.park.server.demo.repository;

import com.park.server.demo.model.CategorieClient;
import com.park.server.demo.model.CategorieFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategorieFournisseurRepository extends JpaRepository<CategorieFournisseur,Long> {
public CategorieFournisseur getCategorieFournisseurByNom(String nom);
}
