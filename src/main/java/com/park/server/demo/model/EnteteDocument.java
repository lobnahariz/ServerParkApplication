package com.park.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class EnteteDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String ref;
    private String dateCreation;
    private String lieuCreation;
    @OneToMany(mappedBy = "enteteDocument", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<LineDocument> linesDocument;

    @ManyToOne(fetch = FetchType.LAZY)
    private Personne personne;

    public EnteteDocument() {
    }

    public EnteteDocument(Long id, String ref, String dateCreation, String lieuCreation) {
        this.id=id;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
      //  this.personne = personne;
        linesDocument=new ArrayList<LineDocument>();
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLieuCreation() {
        return lieuCreation;
    }

    public void setLieuCreation(String lieuCreation) {
        this.lieuCreation = lieuCreation;
    }

    public List<LineDocument> getLinesDocument() {
        return linesDocument;
    }

    public void setLinesDocument(List<LineDocument> linesDocument) {
        this.linesDocument = linesDocument;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
