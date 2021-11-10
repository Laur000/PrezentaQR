package com.qrteam.QResent.models;


import java.util.ArrayList;
import java.util.List;

public class Materie {
    private Integer id;
    private String nume;
    private String detalii;
    private List<Curs> cursuri;

    public Materie() {

    }

    public Materie(Integer id, String nume, String detalii) {
        this.id = id;
        this.nume = nume;
        this.detalii = detalii;
        cursuri = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
