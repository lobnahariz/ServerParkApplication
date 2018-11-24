package com.park.server.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class DevisDocument extends EnteteDocument {

     private String delaiLivraisonSouhaite;


    @ManyToOne(fetch = FetchType.LAZY)
    private BonLivraisonDocument bonLivraisonDocument;

    public DevisDocument() {
    }

    public DevisDocument(Long id, String ref, String dateCreation, String lieuCreation) {
        super(id, ref, dateCreation, lieuCreation);
    }

    public DevisDocument(Long id, String ref, String dateCreation, String lieuCreation, String delaiLivraisonSouhaite) {
        super(id,ref, dateCreation, lieuCreation);
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }

    public String getDelaiLivraisonSouhaite() {
        return delaiLivraisonSouhaite;
    }

    public void setDelaiLivraisonSouhaite(String delaiLivraisonSouhaite) {
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }

    public BonLivraisonDocument getBonLivraisonDocument() {
        return bonLivraisonDocument;
    }

    public void setBonLivraisonDocument(BonLivraisonDocument bonLivraisonDocument) {
        this.bonLivraisonDocument = bonLivraisonDocument;
    }
}
