package com.park.server.demo.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Avoir extends EnteteDocument{

private String description;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private FactureDocument factureDocument;

    public Avoir(String description, FactureDocument factureDocument) {
        this.description = description;
        this.factureDocument = factureDocument;
    }

    public Avoir(Long id, String ref, String dateCreation, String lieuCreation, String achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, String description, FactureDocument factureDocument, String createdBy, String modifiedBy, Date dateCreationAudit) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC, documenttotalTTCReduction,createdBy,modifiedBy,dateCreationAudit);
        this.description = description;
        this.factureDocument = factureDocument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FactureDocument getFactureDocument() {
        return factureDocument;
    }

    public void setFactureDocument(FactureDocument factureDocument) {
        this.factureDocument = factureDocument;
    }
}
