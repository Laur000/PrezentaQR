package com.qrteam.QResent.dto;

import com.qrteam.QResent.models.Curs;

import java.util.List;

public class MaterieDTO {
    private Integer id;
    private String nume;
    private String detalii;
    private List<Curs> cursuri;
    private List<CursDTO> cursuri;

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
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

    public List<CursDTO> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<CursDTO> cursuri) {
        this.cursuri = cursuri;
    }
}
