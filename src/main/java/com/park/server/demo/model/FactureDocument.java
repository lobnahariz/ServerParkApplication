package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FactureDocument extends EnteteDocument {

private String etat;
private float montantPaye;
private String modeReglement;

private String dateLimiteReglement;

private String details;
    private String modifierStock;


    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "factureDocument")
    private Avoir avoir;

    public FactureDocument() {
        super();
    }


    public FactureDocument(Long id, String ref, String dateCreation, String lieuCreation, String achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, String etat, float montantPaye, String modeReglement, String dateLimiteReglement, String details, String createdBy, String modifiedBy, Date dateCreationAudit,String modifierStock) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC, documenttotalTTCReduction,createdBy,modifiedBy,dateCreationAudit);
        this.etat = etat;
        this.montantPaye = montantPaye;
        this.modeReglement = modeReglement;
        this.dateLimiteReglement = dateLimiteReglement;
        this.details = details;
        this.modifierStock = modifierStock;
    }

    public String getModifierStock() {
        return modifierStock;
    }

    public void setModifierStock(String modifierStock) {
        this.modifierStock = modifierStock;
    }

    public Avoir getAvoir() {
        return avoir;
    }

    public void setAvoir(Avoir avoir) {
        this.avoir = avoir;
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


}
