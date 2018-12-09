package com.park.server.demo.modelMapper;

public class ChartWithDateMapModel {
    private String nom;
    private int nombre;
    private String date;

    public ChartWithDateMapModel(String nom, int nombre, String date) {
        this.nom = nom;
        this.nombre = nombre;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
