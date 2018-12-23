package com.park.server.demo.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class ReparationDocument extends EnteteDocument {

     private String delaiRreparationSouhaite;
    private String estAccessoire;
    private String typePanne;
    private float nbHeureTravaille;

    private String etat;
    private String accessoire;

    private String description;

    public ReparationDocument() {
    }

    public ReparationDocument(String delaiRreparationSouhaite, String estAccessoire, String typePanne, float nbHeureTravaille, String etat, String accessoire, String description) {
        this.delaiRreparationSouhaite = delaiRreparationSouhaite;
        this.estAccessoire = estAccessoire;
        this.typePanne = typePanne;
        this.nbHeureTravaille = nbHeureTravaille;
        this.etat = etat;
        this.accessoire = accessoire;
        this.description = description;
    }

    public ReparationDocument(Long id, String ref, String dateCreation, String lieuCreation, String achat, Personne personne, float documenttotalHT, float documenttotalTVA, float documenttotalReduction, float documenttotalTTC, float documenttotalTTCReduction, String createdBy, String modifiedBy, Date dateCreationAudit, String delaiRreparationSouhaite, String estAccessoire, String typePanne, float nbHeureTravaille, String etat, String accessoire, String description) {
        super(id, ref, dateCreation, lieuCreation, achat, personne, documenttotalHT, documenttotalTVA, documenttotalReduction, documenttotalTTC, documenttotalTTCReduction, createdBy, modifiedBy, dateCreationAudit);
        this.delaiRreparationSouhaite = delaiRreparationSouhaite;
        this.estAccessoire = estAccessoire;
        this.typePanne = typePanne;
        this.nbHeureTravaille = nbHeureTravaille;
        this.etat = etat;
        this.accessoire = accessoire;
        this.description = description;
    }

    public String getDelaiRreparationSouhaite() {
        return delaiRreparationSouhaite;
    }

    public void setDelaiRreparationSouhaite(String delaiRreparationSouhaite) {
        this.delaiRreparationSouhaite = delaiRreparationSouhaite;
    }

    public String getEstAccessoire() {
        return estAccessoire;
    }

    public void setEstAccessoire(String estAccessoire) {
        this.estAccessoire = estAccessoire;
    }

    public String getTypePanne() {
        return typePanne;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getAccessoire() {
        return accessoire;
    }

    public void setAccessoire(String accessoire) {
        this.accessoire = accessoire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
