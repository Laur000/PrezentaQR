package com.qrteam.QResent.databaseMock;

import com.qrteam.QResent.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentData {
    private List<Student> students;

    public void init(){
        students = new ArrayList<>();

        List<Integer> materii = new ArrayList<>();

        materii.add(0);
        students.add(new Student("6211008017937", "Andrei", "Bagiu", "emailpentrufacultatefake1@facultate.stud.ro", "414AA", 4, "parolafake1", materii));
        materii = new ArrayList<>();
        materii.add(1);
        students.add(new Student("6211009017673", "Eduard", "Toea", "emailpentrufacultatefake2@facultate.stud.ro","341C2", 3, "parolafake2", materii));
        materii = new ArrayList<>();
        materii.add(2);
        students.add(new Student("6211010016314", "Sergiu", "Sandu", "emailpentrufacultatefake3@facultate.stud.ro","414AA",  4, "parolafake3", materii));
        materii = new ArrayList<>();
        materii.add(3);
        students.add(new Student("6001001016791", "Valentin", "Diaconu", "emailpentrufacultatefake4@facultate.stud.ro","414AA",  3, "parolafake4", materii));
        materii = new ArrayList<>();
        materii.add(4);
        students.add(new Student("6001002018931", "Laurentiu", "Bagiu", "emailpentrufacultatefake5@facultate.stud.ro","414AA", 4, "parolafake5", materii));
        materii = new ArrayList<>();
        materii.add(5);
        students.add(new Student("6001005015045", "Andrei", "Zat", "emailpentrufacultatefake6@facultate.stud.ro", "414AA",3, "parolafake6", materii));
        materii = new ArrayList<>();
        materii.add(6);
        students.add(new Student("6001013015571", "Bogdan", "Bogdy", "emailpentrufacultatefake7@facultate.stud.ro","414AA",  4, "parolafake7", materii));
        materii = new ArrayList<>();
        materii.add(7);
        students.add(new Student("6001021018622", "Lumi", "Lumina", "emailpentrufacultatefake8@facultate.stud.ro", "414AA",3, "parolafake8", materii));
        materii = new ArrayList<>();
        materii.add(8);
        students.add(new Student("6001007015710", "Gigi", "Karma", "emailpentrufacultatefake9@facultate.stud.ro","414AA", 4, "parolafake9", materii));
        materii = new ArrayList<>();
        materii.add(9);
        students.add(new Student("6001029107541", "Camataru", "Costel", "emailpentrufacultatefake10@facultate.stud.ro","414AA", 4, "parolafake10", materii));

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
