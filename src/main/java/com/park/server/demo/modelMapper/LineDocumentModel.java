package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class LineDocumentModel {

    private Long id_line;
    @NotNull
    private String code;


    private int qte;

    private float puHT;

    private int tva;

    private float totalHT;

    private float totalTTC;

    private String enteteDocumentId;
private int reduction;
    private String createdBy;
    private String modifiedBy;
    private Date dateCreationAudit;

    public Long getId_line() {
        return id_line;
    }

    public void setId_line(Long id_line) {
        this.id_line = id_line;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPuHT() {
        return puHT;
    }

    public void setPuHT(float puHT) {
        this.puHT = puHT;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public float getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(float totalHT) {
        this.totalHT = totalHT;
    }

    public float getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(float totalTTC) {
        this.totalTTC = totalTTC;
    }

    public String getEnteteDocumentId() {
        return enteteDocumentId;
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

    public Date getDateCreationAudit() {
        return dateCreationAudit;
    }

    public void setDateCreationAudit(Date dateCreationAudit) {
        this.dateCreationAudit = dateCreationAudit;
    }

    public void setEnteteDocumentId(String enteteDocumentId) {
        this.enteteDocumentId = enteteDocumentId;
    }
}
