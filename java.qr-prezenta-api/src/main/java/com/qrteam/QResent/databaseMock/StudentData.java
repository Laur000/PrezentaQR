package com.qrteam.QResent.databaseMock;

import com.qrteam.QResent.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private List<Student> students;

    public void init(){
        students = new ArrayList<>();

        students.add(new Student("6211008017937", "Andrei", "Bagiu", "emailpentrufacultatefake1@facultate.stud.ro", 4, "parolafake1"));
        students.add(new Student("6211009017673", "Eduard", "Toea", "emailpentrufacultatefake2@facultate.stud.ro", 3, "parolafake2"));
        students.add(new Student("6211010016314", "Sergiu", "Sandu", "emailpentrufacultatefake3@facultate.stud.ro", 4, "parolafake3"));
        students.add(new Student("6001001016791", "Valentin", "Diaconu", "emailpentrufacultatefake4@facultate.stud.ro", 3, "parolafake4"));
        students.add(new Student("6001002018931", "Laurentiu", "Bagiu", "emailpentrufacultatefake5@facultate.stud.ro", 4, "parolafake5"));
        students.add(new Student("6001005015045", "Andrei", "Zat", "emailpentrufacultatefake6@facultate.stud.ro", 3, "parolafake6"));
        students.add(new Student("6001013015571", "Bogdan", "Bogdy", "emailpentrufacultatefake7@facultate.stud.ro", 4, "parolafake7"));
        students.add(new Student("6001021018622", "Lumi", "Lumina", "emailpentrufacultatefake8@facultate.stud.ro", 3, "parolafake8"));
        students.add(new Student("6001007015710", "Gigi", "Karma", "emailpentrufacultatefake9@facultate.stud.ro", 4, "parolafake9"));
        students.add(new Student("6001029107541", "Camataru", "Costel", "emailpentrufacultatefake10@facultate.stud.ro", 4, "parolafake10"));

    }

    public Student getStudentDataByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    public StudentData() {
        init();
    }
}
