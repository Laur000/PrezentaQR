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

        students.add(new Student("6211008017937", "Andrei", "Bagiu", "emailpentrufacultatefake1@facultate.stud.ro", 4, "parolafake1", Arrays.asList(0)));
        students.add(new Student("6211009017673", "Eduard", "Toea", "emailpentrufacultatefake2@facultate.stud.ro", 3, "parolafake2", Arrays.asList(1)));
        students.add(new Student("6211010016314", "Sergiu", "Sandu", "emailpentrufacultatefake3@facultate.stud.ro", 4, "parolafake3", Arrays.asList(2)));
        students.add(new Student("6001001016791", "Valentin", "Diaconu", "emailpentrufacultatefake4@facultate.stud.ro", 3, "parolafake4", Arrays.asList(3)));
        students.add(new Student("6001002018931", "Laurentiu", "Bagiu", "emailpentrufacultatefake5@facultate.stud.ro", 4, "parolafake5", Arrays.asList(4)));
        students.add(new Student("6001005015045", "Andrei", "Zat", "emailpentrufacultatefake6@facultate.stud.ro", 3, "parolafake6", Arrays.asList(5)));
        students.add(new Student("6001013015571", "Bogdan", "Bogdy", "emailpentrufacultatefake7@facultate.stud.ro", 4, "parolafake7", Arrays.asList(6)));
        students.add(new Student("6001021018622", "Lumi", "Lumina", "emailpentrufacultatefake8@facultate.stud.ro", 3, "parolafake8", Arrays.asList(7)));
        students.add(new Student("6001007015710", "Gigi", "Karma", "emailpentrufacultatefake9@facultate.stud.ro", 4, "parolafake9", Arrays.asList(8)));
        students.add(new Student("6001029107541", "Camataru", "Costel", "emailpentrufacultatefake10@facultate.stud.ro", 4, "parolafake10", Arrays.asList(9)));

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
