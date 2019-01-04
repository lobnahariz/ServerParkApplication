package com.park.server.demo.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private int quantite;
    private float prixUnitaire ;
    private float avc ;
    private float margeUnitaire ;
    private float valeurStock ;


    @CreatedDate
    private Date dateCreationAudit;
    @LastModifiedDate
    private Date derniereDateModif;
    private String marque;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategorieProduit categorieProduit;

    public Produit() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(id, produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Produit(String ref, int quantite, float prixUnitaire,float avc,float margeUnitaire,String marque,float valeurStock) {
        this.ref = ref;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.avc=avc;
        this.margeUnitaire=margeUnitaire;
        this.marque=marque;
        this.valeurStock=valeurStock;
    }

    public float getValeurStock() {
        return valeurStock;
    }

    public void setValeurStock(float valeurStock) {
        this.valeurStock = valeurStock;
    }

    public float getAvc() {
        return avc;
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

    public Date getDateCreationAudit() {
        return dateCreationAudit;
    }

    public void setDateCreationAudit(Date dateCreationAudit) {
        this.dateCreationAudit = dateCreationAudit;
    }

    public Date getDerniereDateModif() {
        return derniereDateModif;
    }

    public void setDerniereDateModif(Date derniereDateModif) {
        this.derniereDateModif = derniereDateModif;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
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

    public CategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(CategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }
}
