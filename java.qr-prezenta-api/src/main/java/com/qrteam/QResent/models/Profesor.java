package com.qrteam.QResent.models;


import javax.persistence.Entity;

@Entity
public class Profesor extends Utilizator {
    private String cnp;
    private String firstName;
    private String lastName;
    private String email;
    private Materie materie;

    public Profesor() {

    }

    public Profesor(String cnp, String firstName, String lastName, String email, Materie materie) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.materie = materie;
    }


    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Materie getMaterie() {
        return materie;
    }

    public void setMaterie(Materie materie) {
        this.materie = materie;
    }
}
