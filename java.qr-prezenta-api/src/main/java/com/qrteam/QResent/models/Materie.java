package com.qrteam.QResent.models;


import javax.persistence.Entity;
import java.util.List;

@Entity
public class Materie {
    private Integer id;
    private String nume;
    private List<Curs> cursuri;

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
