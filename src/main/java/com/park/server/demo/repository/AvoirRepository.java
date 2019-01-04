package com.park.server.demo.repository;

import com.park.server.demo.model.Avoir;
import com.park.server.demo.model.DevisDocument;
import com.park.server.demo.model.FactureDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AvoirRepository extends EnteteDocumentBaseRepo<Avoir> {

    @Query("SELECT p FROM Avoir p WHERE p.achat like 'Achat'")
    public List<Avoir> getAllAchatAvoir();

    @Query("SELECT p FROM Avoir p WHERE p.achat like 'Vente'")
    public List<Avoir> getAllVenteAvoir();
}
