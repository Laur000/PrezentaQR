package com.qrteam.QResent.models;


import javax.persistence.Entity;

@Entity
public class Profesor extends Utilizator {
    private String cnp;
    private String firstName;
    private String lastName;


    public Profesor() {
        super();

    }

    public Profesor(String cnp, String firstName, String lastName, String email, String parola) {
        super(email, parola);
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;

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

}
