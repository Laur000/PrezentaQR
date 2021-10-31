package com.qrteam.QResent.models;

public class Materie {
    private Integer id;
    private String nume;

    public Materie() {

    }

    public Materie(Integer id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
