package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;

public class AvoirModel {

    private Long id_avoir;

    private String description;

    private String factureId;

    private int quantite;


    public Long getId_avoir() {
        return id_avoir;
    }

    public void setId_avoir(Long id_avoir) {
        this.id_avoir = id_avoir;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactureId() {
        return factureId;
    }

    public void setFactureId(String factureId) {
        this.factureId = factureId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
