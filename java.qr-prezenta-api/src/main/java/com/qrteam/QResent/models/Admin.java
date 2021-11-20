package com.qrteam.QResent.models;


import javax.persistence.Entity;

@Entity
public class Admin {
    private String usernmae;
    private String password;

    public Admin() {
        this.usernmae = "admin";
        this.password = "admin";
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
}
