package com.park.server.demo.repository;

import com.park.server.demo.model.Produit;
import com.park.server.demo.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {

}
