package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CategorieClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategorie;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "categorieClient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Client> clientList;

    @CreatedDate
    private Date dateCreation;
    @LastModifiedDate

    private Date derniereDateModif;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}