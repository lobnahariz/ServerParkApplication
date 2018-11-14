package com.park.server.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class EnteteDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String ref;
    private String dateCreation;
    private String lieuCreation;
    @OneToMany(mappedBy = "enteteDocument", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Collection<LineDocument> linesDocument;

    public EnteteDocument() {
    }

    public EnteteDocument(String type, String ref, String dateCreation, String lieuCreation, Collection<LineDocument> linesDocument) {
        this.type = type;
        this.ref = ref;
        this.dateCreation = dateCreation;
        this.lieuCreation = lieuCreation;
        this.linesDocument = linesDocument;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<LineDocument> getLinesDocument() {
        return linesDocument;
    }

    public void setLinesDocument(Collection<LineDocument> linesDocument) {
        this.linesDocument = linesDocument;
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
}
