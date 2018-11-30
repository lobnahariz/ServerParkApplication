package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;

public class DevisDocumentModel {

    private Long id;

    @NotNull
    private String ref;

    private String dateCreation;

    private String lieuCreation;

    private int linesDocument;

    private Long personId;
    private String delaiLivraisonSouhaite;

    private Boolean achat;

    private float documenttotalHT;
    private float documenttotalTVA;
    private float documenttotalReduction;
    private float documenttotalTTC;
    private float documenttotalTTCReduction;

    public DevisDocumentModel() {
    }

    public DevisDocumentModel(Long id, @NotNull String ref, String dateCreation, String lieuCreation, int linesDocument, Long personId, String delaiLivraisonSouhaite, Boolean achat, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction) {
        this.id = id;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
        this.linesDocument = linesDocument;
        this.personId = personId;
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
        this.achat = achat;
        this.documenttotalHT = documenttotalHT;
        this.documenttotalTVA = documenttotalTVA;
        this.documenttotalReduction = documenttotalReduction;
        this.documenttotalTTC = documenttotalTTC;
        this.documenttotalTTCReduction = documenttotalTTCReduction;
    }

    public float getDocumenttotalHT() {
        return documenttotalHT;
    }

    public void setDocumenttotalHT(float documenttotalHT) {
        this.documenttotalHT = documenttotalHT;
    }

    public float getDocumenttotalTVA() {
        return documenttotalTVA;
    }

    public void setDocumenttotalTVA(float documenttotalTVA) {
        this.documenttotalTVA = documenttotalTVA;
    }

    public float getDocumenttotalReduction() {
        return documenttotalReduction;
    }

    public void setDocumenttotalReduction(float documenttotalReduction) {
        this.documenttotalReduction = documenttotalReduction;
    }

    public float getDocumenttotalTTC() {
        return documenttotalTTC;
    }

    public void setDocumenttotalTTC(float documenttotalTTC) {
        this.documenttotalTTC = documenttotalTTC;
    }

    public float getDocumenttotalTTCReduction() {
        return documenttotalTTCReduction;
    }

    public void setDocumenttotalTTCReduction(float documenttotalTTCReduction) {
        this.documenttotalTTCReduction = documenttotalTTCReduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAchat() {
        return achat;
    }

    public void setAchat(Boolean achat) {
        this.achat = achat;
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getDelaiLivraisonSouhaite() {
        return delaiLivraisonSouhaite;
    }

    public void setDelaiLivraisonSouhaite(String delaiLivraisonSouhaite) {
        this.delaiLivraisonSouhaite = delaiLivraisonSouhaite;
    }


}
