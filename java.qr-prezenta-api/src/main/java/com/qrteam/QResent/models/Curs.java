package com.qrteam.QResent.models;


import javax.persistence.Entity;

@Entity
public class Curs {
    private Integer cursId;
    private String nume;
    private String detalii;


    public Curs() {

    }

    public Curs(Integer cursId, String nume, String detalii) {
        this.cursId = cursId;
        this.nume = nume;
        this.detalii = detalii;
    }

    public Integer getCursId() {
        return cursId;
    }

    public void setCursId(Integer cursId) {
        this.cursId = cursId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }
}
