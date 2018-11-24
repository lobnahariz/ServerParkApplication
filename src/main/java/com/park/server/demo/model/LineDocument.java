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

    public LineDocument() {
      //  this.id_line = UUID.randomUUID();
    }

    public LineDocument(Long id, String code,int qte,float puHT,int tva,float totalHT,float totalTTC,EnteteDocument enteteDocument) {
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
    }
}
