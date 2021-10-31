package com.qrteam.QResent.dto;

import com.qrteam.QResent.models.Materie;

import java.util.ArrayList;
import java.util.List;

public class ProfesorDTO {
    private String cnp;
    private String firstName;
    private String lastName;
    private String email;

    public ProfesorDTO() {

    }

    public ProfesorDTO(String cnp, String firstName, String lastName, String email) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

}
