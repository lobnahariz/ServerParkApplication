package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BonDeLivraisonDocumentModel {

    private Long id;

    @NotNull
    private String ref;

    private String dateCreation;

    private String lieuCreation;

    private int linesDocument;
    private String achat;

    private Long personId;
    private boolean accuse_reception;
    private String receptionDate;
    private String receptionPersonne;
    private float documenttotalHT;
    private float documenttotalTVA;
    private float documenttotalReduction;
    private float documenttotalTTC;
    private float documenttotalTTCReduction;
    private String createdBy;
    private String modifiedBy;
    private Date dateCreationAudit;
    public BonDeLivraisonDocumentModel() {
    }

    public BonDeLivraisonDocumentModel(Long id, @NotNull String ref, String dateCreation, String lieuCreation, int linesDocument, String achat, Long personId, boolean accuse_reception, String receptionDate, String receptionPersonne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction,String createdBy,String modifiedBy,Date dateCreationAudit) {
        this.id = id;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
        this.linesDocument = linesDocument;
        this.achat = achat;
        this.personId = personId;
        this.accuse_reception = accuse_reception;
        this.receptionDate = receptionDate;
        this.receptionPersonne = receptionPersonne;
        this.documenttotalHT = documenttotalHT;
        this.documenttotalTVA = documenttotalTVA;
        this.documenttotalReduction = documenttotalReduction;
        this.documenttotalTTC = documenttotalTTC;
        this.documenttotalTTCReduction = documenttotalTTCReduction;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.dateCreationAudit = dateCreationAudit;
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


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getAchat() {
        return achat;
    }

    public void setAchat(String achat) {
        this.achat = achat;
    }

    public boolean isAccuse_reception() {
        return accuse_reception;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDateCreationAudit() {
        return dateCreationAudit;
    }

    public void setDateCreationAudit(Date dateCreationAudit) {
        this.dateCreationAudit = dateCreationAudit;
    }
}
