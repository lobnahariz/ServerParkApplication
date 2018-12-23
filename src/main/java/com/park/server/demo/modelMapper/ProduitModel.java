package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProduitModel {

    private Long id;


    private String ref;
    private String marque;

    private int quantite;

    private float prixUnitaire;

    private String createdBy;
    private String modifiedBy;
    private Date dateCreation;

    private String categorieCode;
    private Date derniereDateModif;

    private float avc;
    private float margeUnitaire;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCategorieCode() {
        return categorieCode;
    }

    public void setCategorieCode(String categorieCode) {
        this.categorieCode = categorieCode;
    }

    public Date getDerniereDateModif() {
        return derniereDateModif;
    }

    public float getAvc() {
        return avc;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setAvc(float avc) {
        this.avc = avc;
    }

    public float getMargeUnitaire() {
        return margeUnitaire;
    }

    public void setMargeUnitaire(float margeUnitaire) {
        this.margeUnitaire = margeUnitaire;
    }

    public void setDerniereDateModif(Date derniereDateModif) {
        this.derniereDateModif = derniereDateModif;
    }
}
