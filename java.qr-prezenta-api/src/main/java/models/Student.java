package models;

import java.util.List;

public class Student {
    private Integer studentId;
    private String cnp;
    private String firstName;
    private String lastName;
    private String email;
    private int yearOfStudy;
    private List<Materie> materie;

    public Student() {

    }

    public Student(Integer studentId, String cnp, String firstName, String lastName, String email, int yearOfStudy, List<Materie> materie) {
        this.studentId = studentId;
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearOfStudy = yearOfStudy;
        this.materie = materie;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public List<Materie> getMaterie() {
        return materie;
    }

    public void setMaterie(List<Materie> materie) {
        this.materie = materie;
    }
}
