package com.park.server.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class DevisDocument extends EnteteDocument {

     private String delaiLivraisonSouhaite;



    public DevisDocument() {
        super();
    }


    public DevisDocument(Long id, String ref, String dateCreation, String lieuCreation, Boolean achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, String delaiLivraisonSouhaite) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC, documenttotalTTCReduction);
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }

    public String getDelaiLivraisonSouhaite() {
        return delaiLivraisonSouhaite;
    }

    public void setDelaiLivraisonSouhaite(String delaiLivraisonSouhaite) {
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }


}
