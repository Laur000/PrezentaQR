package com.qrteam.QResent.models;


import javax.persistence.Entity;

@Entity
public class Utilizator {
    private String email;
    private String parola;

    public Utilizator(String email, String parola) {
        this.email = email;
        this.parola = parola;
    }
    public Utilizator() {
    }
}
