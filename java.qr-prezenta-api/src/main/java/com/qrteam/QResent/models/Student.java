package com.qrteam.QResent.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Student extends Utilizator {
    private String cnp;
    private String firstName;
    private String lastName;
    private int yearOfStudy;
    private List<Integer> materii;

    public Student() {

    }

    public Student(String cnp, String firstName, String lastName, String email, int yearOfStudy, String parola) {
        super(email, parola);
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfStudy = yearOfStudy;

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

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public List<Integer> getMaterii() {
        return materii;
    }

    public void setMaterii(List<Integer> materii) {
        this.materii = materii;
    }
}
