package com.qrteam.QResent.dto;

public class SaveDisciplineDTO {
    private MaterieDTO materie;
    private String emailProfesor;

    public MaterieDTO getMaterie() {
        return materie;
    }

    public void setMaterie(MaterieDTO materie) {
        this.materie = materie;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }
}
