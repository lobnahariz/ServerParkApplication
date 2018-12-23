package com.park.server.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Fournisseur extends Personne {


    @ManyToOne(fetch = FetchType.EAGER)
    private CategorieFournisseur categorieFournisseur;

    public Fournisseur() {
    }

    public Fournisseur(Long id, String libelle, String nom, String prenom, String nomSociete, String mail, String telephoneFixe, String telephonePortable, String rib, String adresse, String createdBy, String modifiedBy, Date dateCreation,String ville,CategorieFournisseur categorieFournisseur, Date derniereDateModif) {
        super(id,libelle, nom, prenom, nomSociete, mail, telephoneFixe, telephonePortable, rib, adresse,createdBy,modifiedBy,dateCreation,ville, derniereDateModif);
        this.categorieFournisseur=categorieFournisseur;

    }

    public CategorieFournisseur getCategorieFournisseur() {
        return categorieFournisseur;
    }

    public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
        this.categorieFournisseur = categorieFournisseur;
    }
}
