package com.qrteam.QResent.models;

public class Profesor {
    private Integer profesorID;
    private String cnp;
    private String firstName;
    private String lastName;
    private String email;
    private Materie materie;

    public Profesor() {

    }

    public Profesor(Integer profesorID, String cnp, String firstName, String lastName, String email, Materie materie) {
        this.profesorID = profesorID;
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.materie = materie;
    }

    public Integer getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(Integer profesorID) {
        this.profesorID = profesorID;
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
