package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ReclamationModel {


    private Long id;

    private String titre;

    private String description;

    private String valide;

    private Date dateCreationAudit;
    private Date derniereDateModif;

    private String createdBy;
    private String modifiedBy;

    public ReclamationModel() {
    }

    public ReclamationModel(Long id, String titre, String description, String valide, Date dateCreationAudit, Date derniereDateModif, String createdBy, String modifiedBy) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.valide = valide;
        this.dateCreationAudit = dateCreationAudit;
        this.derniereDateModif = derniereDateModif;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public Date getDateCreationAudit() {
        return dateCreationAudit;
    }

    public void setDateCreationAudit(Date dateCreationAudit) {
        this.dateCreationAudit = dateCreationAudit;
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
}