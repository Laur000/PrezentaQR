package com.qrteam.QResent.models;


import javax.persistence.Entity;

@Entity
public class Admin {

    private String firstName;
    private String lastName;
    private String usernmae;
    private String password;

    public Admin() {
        this.usernmae = "admin";
        this.password = "admin";
        this.firstName = "Mihnea";
        this.lastName = "Moisescu";
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
