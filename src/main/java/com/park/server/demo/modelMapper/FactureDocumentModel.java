package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FactureDocumentModel {

    private Long id;

    @NotNull
    private String ref;

    private String dateCreation;

    private String lieuCreation;

    private int linesDocument;

    private Long personId;
    private String etat;
    private float montantPaye;
    private String modeReglement;

    private String dateLimiteReglement;

    private String details;

    private String achat;
private  String modifierStock;
    private float documenttotalHT;
    private float documenttotalTVA;
    private float documenttotalReduction;
    private float documenttotalTTC;
    private float documenttotalTTCReduction;
    private String createdBy;
    private String modifiedBy;
    private Date dateCreationAudit;
    public FactureDocumentModel() {
    }

    public FactureDocumentModel(Long id, @NotNull String ref, String dateCreation, String lieuCreation, int linesDocument, Long personId, String etat, float montantPaye, String modeReglement, String dateLimiteReglement, String details, String achat, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction,String createdBy,String modifiedBy,Date dateCreationAudit,String modifierStock) {
        this.id = id;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
        this.linesDocument = linesDocument;
        this.personId = personId;
        this.etat = etat;
        this.montantPaye = montantPaye;
        this.modeReglement = modeReglement;
        this.dateLimiteReglement = dateLimiteReglement;
        this.details = details;
        this.achat = achat;
        this.documenttotalHT = documenttotalHT;
        this.documenttotalTVA = documenttotalTVA;
        this.documenttotalReduction = documenttotalReduction;
        this.documenttotalTTC = documenttotalTTC;
        this.documenttotalTTCReduction = documenttotalTTCReduction;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.dateCreationAudit = dateCreationAudit;
        this.modifierStock =modifierStock;
    }

    public String getModifierStock() {
        return modifierStock;
    }

    public void setModifierStock(String modifierStock) {
        this.modifierStock = modifierStock;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    public String getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(String modeReglement) {
        this.modeReglement = modeReglement;
    }

    public String getDateLimiteReglement() {
        return dateLimiteReglement;
    }

    public void setDateLimiteReglement(String dateLimiteReglement) {
        this.dateLimiteReglement = dateLimiteReglement;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAchat() {
        return achat;
    }

    public void setAchat(String achat) {
        this.achat = achat;
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
