package com.park.server.demo.repository;

import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.FactureDocument;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
public interface FactureRepository extends EnteteDocumentBaseRepo<FactureDocument> {

    @Query("SELECT p FROM FactureDocument p WHERE p.montantPaye < p.documenttotalTTCReduction ")
    public List<FactureDocument> getAllFactureNonPaye();

    public FactureDocument getFactureDocumentByRef(String ref);

    @Query("SELECT p FROM FactureDocument p WHERE p.montantPaye < p.documenttotalTTCReduction ")
    public  List<FactureDocument> getFactureDocument();

    @Query("SELECT p FROM FactureDocument p WHERE p.modifierStock like 'Oui' ")
    public List<FactureDocument> getFactureWithNoStockUpdate();
}
