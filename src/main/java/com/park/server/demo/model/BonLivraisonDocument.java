package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class BonLivraisonDocument extends EnteteDocument {

private boolean accuse_reception;
private String receptionDate;
private String receptionPersonne;




    public BonLivraisonDocument() {
        super();
    }

    public BonLivraisonDocument(boolean accuse_reception, String receptionDate, String receptionPersonne) {
        this.accuse_reception = accuse_reception;
        this.receptionDate = receptionDate;
        this.receptionPersonne = receptionPersonne;
    }

    public BonLivraisonDocument(Long id, String ref, String dateCreation, String lieuCreation, Boolean achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, boolean accuse_reception, String receptionDate, String receptionPersonne) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC, documenttotalTTCReduction);
        this.accuse_reception = accuse_reception;
        this.receptionDate = receptionDate;
        this.receptionPersonne = receptionPersonne;
    }

    public boolean getAccuse_reception() {
        return accuse_reception;
    }

    public void setAccuse_reception(boolean accuse_reception) {
        this.accuse_reception = accuse_reception;
    }

    public String getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(String receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getReceptionPersonne() {
        return receptionPersonne;
    }

    public void setReceptionPersonne(String receptionPersonne) {
        this.receptionPersonne = receptionPersonne;
    }


}
