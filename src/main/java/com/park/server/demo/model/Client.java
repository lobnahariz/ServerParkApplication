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

    public Client() {
    }

    public Client(Long id, String libelle, String nom, String prenom, String nomSociete, String mail, String telephoneFixe, String telephonePortable, String rib, String adresse, String createdBy, String modifiedBy, Date dateCreation,String ville) {
        super(id,libelle, nom, prenom, nomSociete, mail, telephoneFixe, telephonePortable, rib, adresse,createdBy,modifiedBy,dateCreation,ville);
    }
}
