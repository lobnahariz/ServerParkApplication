package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class EnteteDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTETE")
    private Long id;

    private String ref;
    private String dateCreation;
    private String lieuCreation;
    private Boolean achat;
    @OneToMany(mappedBy = "enteteDocument", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<LineDocument> linesDocument;

    @ManyToOne(fetch = FetchType.LAZY)
    private Personne personne;
private float documenttotalHT;
private float documenttotalTVA;
private float documenttotalReduction;
private float documenttotalTTC;
private float documenttotalTTCReduction;


    public EnteteDocument() {
    }

    public EnteteDocument(Long id, String ref, String dateCreation, String lieuCreation, Boolean achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction) {
        this.id=id;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
        this.achat = achat;
        this.linesDocument = linesDocument;
        this.personne = personne;
        this.documenttotalHT = documenttotalHT;
        this.documenttotalTVA = documenttotalTVA;
        this.documenttotalReduction = documenttotalReduction;
        this.documenttotalTTC = documenttotalTTC;
        this.documenttotalTTCReduction = documenttotalTTCReduction;
        linesDocument=new ArrayList<LineDocument>();

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

    public Boolean getAchat() {
        return achat;
    }

    public void setAchat(Boolean achat) {
        this.achat = achat;
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

    public List<LineDocument> getLinesDocument() {
        return linesDocument;
    }

    public void setLinesDocument(List<LineDocument> linesDocument) {
        this.linesDocument = linesDocument;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
