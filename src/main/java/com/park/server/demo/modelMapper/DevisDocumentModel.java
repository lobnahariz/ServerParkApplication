package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;

public class DevisDocumentModel {

    private Long id;

    @NotNull
    private String ref;

    private String dateCreation;

    private String lieuCreation;

    private int linesDocument;

    private Long personneId;
    private String delaiLivraisonSouhaite;
    private Long bonDeLivraisonId;

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

    public String getDelaiLivraisonSouhaite() {
        return delaiLivraisonSouhaite;
    }

    public void setDelaiLivraisonSouhaite(String delaiLivraisonSouhaite) {
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }

    public Long getBonDeLivraisonId() {
        return bonDeLivraisonId;
    }

    public void setBonDeLivraisonId(Long bonDeLivraisonId) {
        this.bonDeLivraisonId = bonDeLivraisonId;
    }
}
