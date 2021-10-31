package com.qrteam.QResent.dto;

import com.qrteam.QResent.models.Materie;

import java.util.ArrayList;
import java.util.List;

public class ProfesorDTO {
    private String cnp;
    private String firstName;
    private String lastName;
    private String email;

    private List<Materie> materii;

    public ProfesorDTO() {

    }

    public ProfesorDTO(String cnp, String firstName, String lastName, String email) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.materii = new ArrayList<>();
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

    public List<Materie> getMaterii() {
        return materii;
    }

    public void setMaterii(List<Materie> materii) {
        this.materii = materii;
    }

    public void addMaterie(Materie materie) {
        this.materii.add(materie);
    }

    public void removeMaterie(Integer id) {
        for (Materie materie : materii) {
            if (materie.getId() == id) {
                materii.remove(materie);
            }
        }
    }
}
