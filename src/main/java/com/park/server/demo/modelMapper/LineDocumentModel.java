package com.park.server.demo.modelMapper;

import javax.validation.constraints.NotNull;

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

    public Long getId_line() {
        return id_line;
    }

    public void setId_line(Long id_line) {
        this.id_line = id_line;
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

    public void setEnteteDocumentId(String enteteDocumentId) {
        this.enteteDocumentId = enteteDocumentId;
    }
}
