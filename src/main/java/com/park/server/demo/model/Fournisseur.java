package com.park.server.demo.model;

import javax.persistence.Entity;

@Entity
public class Fournisseur extends Personne {

    public Fournisseur() {
    }

    public Fournisseur(Long id,String libelle, String nom, String prenom, String nomSociete, String mail, String telephoneFixe, String telephonePortable, String rib, String adresse) {
        super(id,libelle, nom, prenom, nomSociete, mail, telephoneFixe, telephonePortable, rib, adresse);
    }
}
