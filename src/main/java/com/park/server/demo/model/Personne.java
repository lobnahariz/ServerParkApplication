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
@Inheritance
@DiscriminatorColumn(name = "genre")
@EntityListeners(AuditingEntityListener.class)
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libelle;
    private String nom;
    private String prenom ;
    private String nomSociete ;
    private String mail;
    private String telephoneFixe;
    private String telephonePortable;
    private String rib;
    private String adresse;
    private String ville;
    @CreatedDate
    private Date dateCreation;
    @LastModifiedDate
    private Date derniereDateModif;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;
    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<EnteteDocument> personneDocuments;

    public Personne() {
    }

    public Personne(Long id, String libelle, String nom, String prenom, String nomSociete, String mail, String telephoneFixe, String telephonePortable, String rib, String adresse,String createdBy,String modifiedBy,Date dateCreation,String ville) {
       this.id=id;
        this.libelle = libelle;
        this.nom = nom;
        this.prenom = prenom;
        this.nomSociete = nomSociete;
        this.mail = mail;
        this.telephoneFixe = telephoneFixe;
        this.telephonePortable = telephonePortable;
        this.rib = rib;
        this.adresse = adresse;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.dateCreation = dateCreation;
        this.ville=ville;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephoneFixe() {
        return telephoneFixe;
    }

    public void setTelephoneFixe(String telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }

    public String getTelephonePortable() {
        return telephonePortable;
    }

    public void setTelephonePortable(String telephonePortable) {
        this.telephonePortable = telephonePortable;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<EnteteDocument> getPersonneDocuments() {
        return personneDocuments;
    }

    public void setPersonneDocuments(List<EnteteDocument> personneDocuments) {
        this.personneDocuments = personneDocuments;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDerniereDateModif() {
        return derniereDateModif;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setDerniereDateModif(Date derniereDateModif) {
        this.derniereDateModif = derniereDateModif;
    }
}
