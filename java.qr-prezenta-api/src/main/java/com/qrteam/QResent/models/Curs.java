package com.qrteam.QResent.models;


import javax.persistence.Entity;
import java.util.List;

@Entity
public class Curs {
    private Integer cursId;
    private String nume;
    private String detalii;
    private List<Student> listaPrezenta;


    public Curs() {

    }

    public Curs(Integer cursId, String nume, String detalii, List<Student> listaPrezenta) {
        this.cursId = cursId;
        this.nume = nume;
        this.detalii = detalii;
        this.listaPrezenta = listaPrezenta;
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

    public List<Student> getListaPrezenta() {
        return listaPrezenta;
    }

    public void setListaPrezenta(List<Student> listaPrezenta) {
        this.listaPrezenta = listaPrezenta;
    }
}
