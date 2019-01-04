package com.park.server.demo.repository;

import com.park.server.demo.model.ReparationDocument;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ReparationRepository extends EnteteDocumentBaseRepo<ReparationDocument> {

    @Query("SELECT p FROM ReparationDocument p WHERE p.etat like 'Terminée' ")
    public List<ReparationDocument> getReparationDocumentTermine();

    @Query("SELECT COUNT(p) FROM ReparationDocument p WHERE p.etat like 'En Attente' ")
    public int getNombreReparationEnAttente();

    @Query("SELECT COUNT(p) FROM ReparationDocument p WHERE p.etat like 'En cours' ")
    public int getNombreReparationEncours();

    @Query("SELECT COUNT(p) FROM ReparationDocument p WHERE p.etat like 'Nouvelle' ")
    public int getNombreReparationNouvelle();
}
