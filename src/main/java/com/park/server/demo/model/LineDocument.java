package com.park.server.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
public class LineDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_line;

    private String code;

    private int qte;

    private float puHT;

    private int tva;

    private float totalHT;

    private float totalTTC;

    @ManyToOne(fetch = FetchType.LAZY)
    private EnteteDocument enteteDocument;
    private int reduction;

    public LineDocument() {
      //  this.id_line = UUID.randomUUID();
    }

    public LineDocument(Long id, String code,int qte,float puHT,int tva,float totalHT,float totalTTC,EnteteDocument enteteDocument,int reduction) {
        this();
       /* if (id != null) {
            this.id_line = UUID.fromString(id);
        }*/
       this.id_line=id;
        this.code = code;
        this.qte = qte;
        this.puHT = puHT;
        this.tva = tva;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.enteteDocument = enteteDocument;
        this.reduction = reduction;
    }

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

    public EnteteDocument getEnteteDocument() {
        return enteteDocument;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public void setEnteteDocument(EnteteDocument enteteDocument) {
        this.enteteDocument = enteteDocument;
    }
}
