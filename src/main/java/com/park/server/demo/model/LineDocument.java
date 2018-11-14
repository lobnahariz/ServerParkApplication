package com.park.server.demo.model;

import javax.persistence.*;

@Entity
public class LineDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_line;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private EnteteDocument enteteDocument;

    private String code;

    private int qte;

    private float puHT;

    private int tva;

    private float totalHT;

    private float totalTTC;


    public LineDocument() {
    }

    public LineDocument(EnteteDocument enteteDocument, String code, int qte, float puHT, int tva, float totalHT, float totalTTC) {
        this.enteteDocument = enteteDocument;
        this.code = code;
        this.qte = qte;
        this.puHT = puHT;
        this.tva = tva;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
    }

    public Long getId_line() {
        return id_line;
    }

    public void setId_line(Long id_line) {
        this.id_line = id_line;
    }

    public EnteteDocument getEnteteDocument() {
        return enteteDocument;
    }

    public void setEnteteDocument(EnteteDocument enteteDocument) {
        this.enteteDocument = enteteDocument;
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
}
