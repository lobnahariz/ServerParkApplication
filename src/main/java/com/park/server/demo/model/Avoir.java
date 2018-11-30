package com.park.server.demo.model;

import javax.persistence.*;

@Entity
public class Avoir {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_avoir;

    private int quantite;
private String description;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private FactureDocument factureDocument;

    public Avoir(Long id,int quantite, String description, FactureDocument factureDocument) {
      this.id_avoir =id;
        this.quantite = quantite;
        this.description = description;
        this.factureDocument = factureDocument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_avoir() {
        return id_avoir;
    }

    public void setId_avoir(Long id_avoir) {
        this.id_avoir = id_avoir;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public FactureDocument getFactureDocument() {
        return factureDocument;
    }

    public void setFactureDocument(FactureDocument factureDocument) {
        this.factureDocument = factureDocument;
    }
}
