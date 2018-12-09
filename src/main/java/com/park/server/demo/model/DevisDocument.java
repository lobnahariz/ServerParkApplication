package com.park.server.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DevisDocument extends EnteteDocument {

     private String delaiLivraisonSouhaite;



    public DevisDocument() {
        super();
    }


    public DevisDocument(Long id, String ref, String dateCreation, String lieuCreation, String achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, String delaiLivraisonSouhaite, String createdBy, String modifiedBy, Date dateCreationAudit) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC,documenttotalTTCReduction, createdBy,modifiedBy,dateCreationAudit);
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }

    public String getDelaiLivraisonSouhaite() {
        return delaiLivraisonSouhaite;
    }

    public void setDelaiLivraisonSouhaite(String delaiLivraisonSouhaite) {
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }


}
