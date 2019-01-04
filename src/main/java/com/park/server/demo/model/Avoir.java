package com.park.server.demo.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Avoir extends EnteteDocument{

private String factureReference;


    public Avoir() {
    }

    public Avoir(String factureRefrence) {
        this.factureReference = factureRefrence;
    }

    public Avoir(Long id, String ref, String dateCreation,
                 String lieuCreation, String achat,
                 Personne personne, float documenttotalHT,
                 float documenttotalTVA, float documenttotalReduction,
                 float documenttotalTTC, float documenttotalTTCReduction,
                 String factureRefrence, String createdBy,
                 String modifiedBy, Date dateCreationAudit) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC, documenttotalTTCReduction,createdBy,modifiedBy,dateCreationAudit);
        this.factureReference = factureRefrence;
    }

    public String getFactureReference() {
        return factureReference;
    }

    public void setFactureReference(String factureReference) {
        this.factureReference = factureReference;
    }
}
