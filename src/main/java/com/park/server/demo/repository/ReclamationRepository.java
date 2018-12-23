package com.park.server.demo.repository;

import com.park.server.demo.model.Produit;
import com.park.server.demo.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {

    @Query("SELECT p FROM Reclamation p WHERE p.valide like 'false' ")
    public List<Reclamation> getAllNotValid();
}
