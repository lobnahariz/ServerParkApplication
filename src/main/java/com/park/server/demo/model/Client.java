package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Client extends Personne {

    @ManyToOne(fetch = FetchType.EAGER)
    private CategorieClient categorieClient;

    public Client() {
    }

    public Client(Long id, String libelle, String nom, String prenom, String nomSociete, String mail, String telephoneFixe, String telephonePortable, String rib, String adresse, String createdBy, String modifiedBy, Date dateCreation,String ville,CategorieClient categorieClient,Date derniereDateModif) {
        super(id,libelle, nom, prenom, nomSociete, mail, telephoneFixe, telephonePortable, rib, adresse,createdBy,modifiedBy,dateCreation,ville,derniereDateModif);
   this.categorieClient=categorieClient;
    }

    public CategorieClient getCategorieClient() {
        return categorieClient;
    }

    public void setCategorieClient(CategorieClient categorieClient) {
        this.categorieClient = categorieClient;
    }
}
