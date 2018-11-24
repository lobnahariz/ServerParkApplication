package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;

public class BonDeLivraisonDocumentModel {

    private Long id;

    @NotNull
    private String ref;

    private String dateCreation;

    private String lieuCreation;

    private int linesDocument;

    private Long personneId;
    private boolean accuse_reception;
    private String receptionDate;
    private String receptionPersonne;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLieuCreation() {
        return lieuCreation;
    }

    public void setLieuCreation(String lieuCreation) {
        this.lieuCreation = lieuCreation;
    }

    public int getLinesDocument() {
        return linesDocument;
    }

    public void setLinesDocument(int linesDocument) {
        this.linesDocument = linesDocument;
    }

    public Long getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
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
