package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ReparationModel {


    private Long id;

    @NotNull
    private String ref;

    private String dateCreation;

    private String lieuCreation;

    private int linesDocument;

    private Long personId;

    private String achat;
    private String description;

    private float documenttotalHT;
    private float documenttotalTVA;
    private float documenttotalReduction;
    private float documenttotalTTC;
    private float documenttotalTTCReduction;

    private String createdBy;
    private String modifiedBy;
    private Date dateCreationAudit;

    private String delaiRreparationSouhaite;
    private String etat;
    private String typePanne;
    private float nbHeureTravaille;

    private String estAccessoire;
    private String accessoire;

    public ReparationModel() {
    }

    public ReparationModel(Long id, @NotNull String ref, String dateCreation, String lieuCreation, int linesDocument, Long personId, String achat, String description, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, String createdBy, String modifiedBy, Date dateCreationAudit, String delaiRreparationSouhaite, String etat, String typePanne, float nbHeureTravaille, String estAccessoire, String accessoire) {
        this.id = id;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
        this.linesDocument = linesDocument;
        this.personId = personId;
        this.achat = achat;
        this.description = description;
        this.documenttotalHT = documenttotalHT;
        this.documenttotalTVA = documenttotalTVA;
        this.documenttotalReduction = documenttotalReduction;
        this.documenttotalTTC = documenttotalTTC;
        this.documenttotalTTCReduction = documenttotalTTCReduction;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.dateCreationAudit = dateCreationAudit;
        this.delaiRreparationSouhaite = delaiRreparationSouhaite;
        this.etat = etat;
        this.typePanne=typePanne;
        this.nbHeureTravaille=nbHeureTravaille;
        this.estAccessoire=estAccessoire;
        this.accessoire=accessoire;
    }

    public String getTypePanne() {
        return typePanne;
    }

    public String getAccessoire() {
        return accessoire;
    }

    public void setAccessoire(String accessoire) {
        this.accessoire = accessoire;
    }

    public void setTypePanne(String typePanne) {
        this.typePanne = typePanne;
    }

    public float getNbHeureTravaille() {
        return nbHeureTravaille;
    }

    public void setNbHeureTravaille(float nbHeureTravaille) {
        this.nbHeureTravaille = nbHeureTravaille;
    }

    public String getEstAccessoire() {
        return estAccessoire;
    }

    public void setEstAccessoire(String estAccessoire) {
        this.estAccessoire = estAccessoire;
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

    public String getAchat() {
        return achat;
    }

    public void setAchat(String achat) {
        this.achat = achat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDelaiRreparationSouhaite() {
        return delaiRreparationSouhaite;
    }

    public void setDelaiRreparationSouhaite(String delaiRreparationSouhaite) {
        this.delaiRreparationSouhaite = delaiRreparationSouhaite;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
