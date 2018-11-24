package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class BonLivraisonDocument extends EnteteDocument {

private boolean accuse_reception;
private String receptionDate;
private String receptionPersonne;

    @OneToMany(mappedBy = "bonLivraisonDocument", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<DevisDocument> devisDocuments;

    public BonLivraisonDocument(Long id, String ref, String dateCreation, String lieuCreation) {
        super(id, ref, dateCreation, lieuCreation);
    }

    public BonLivraisonDocument(Long id, String ref, String dateCreation, String lieuCreation, boolean accuse_reception, String receptionDate, String receptionPersonne) {
        super(id, ref, dateCreation, lieuCreation);
        this.accuse_reception = accuse_reception;
        this.receptionDate = receptionDate;
        this.receptionPersonne = receptionPersonne;
    }


    public boolean isAccuse_reception() {
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
