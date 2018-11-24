package com.park.server.demo.model;

import javax.persistence.Entity;

@Entity
public class FactureDocument extends EnteteDocument {

private String etat;
private float montantPaye;
private String modeReglement;

private String dateLimiteReglement;

private String details;

    public FactureDocument(Long id, String ref, String dateCreation, String lieuCreation) {
        super(id, ref, dateCreation, lieuCreation);
    }

    public FactureDocument(Long id, String ref, String dateCreation, String lieuCreation, String etat, float montantPaye, String modeReglement, String dateLimiteReglement, String details) {
        super(id, ref, dateCreation, lieuCreation);
        this.etat = etat;
        this.montantPaye = montantPaye;
        this.modeReglement = modeReglement;
        this.dateLimiteReglement = dateLimiteReglement;
        this.details = details;
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
