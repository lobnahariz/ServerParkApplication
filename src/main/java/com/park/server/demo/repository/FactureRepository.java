package com.park.server.demo.repository;

import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.FactureDocument;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT p FROM FactureDocument p WHERE p.personne.id like :id ")
    public  List<FactureDocument> getFactureDocumentByPersonne(@Param("id") Long id);

    @Query("SELECT p FROM FactureDocument p WHERE p.achat like 'Achat' and p.montantPaye < p.documenttotalTTCReduction and p.personne.id like :id")
    public List<FactureDocument> getAllAchatFactureNonPaye(@Param("id") Long id);

    @Query("SELECT p FROM FactureDocument p WHERE p.achat like 'Achat'")
    public List<FactureDocument> getAllAchatFacture();

    @Query("SELECT p FROM FactureDocument p WHERE p.achat like 'Vente'")
    public List<FactureDocument> getAllVenteFacture();

    @Query("SELECT p FROM FactureDocument p WHERE p.achat like 'Achat' and p.montantPaye < p.documenttotalTTCReduction")
    public List<FactureDocument> getAllAchatFactureNonPayeParMois();

    @Query("SELECT p FROM FactureDocument p WHERE p.achat like 'Vente' and p.montantPaye = p.documenttotalTTCReduction")
    public List<FactureDocument> getAllAchatFacturePayeParMois();

}
