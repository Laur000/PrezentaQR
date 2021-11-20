package com.qrteam.QResent.databaseMock;

import com.qrteam.QResent.models.Profesor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfesorData {
    private List<Profesor> profesori;

    public void init(){
        profesori = new ArrayList<>();

        MaterieData materieData = new MaterieData();
        List<Integer> materii = new ArrayList<>();

        materii.add(0);
        profesori.add(new Profesor("6001006035499", "Ion", "Ionel", "emailpentrufacultateprof1@facultate.prof.ro", "parolaprof1",materii));
        materii = new ArrayList<>();
        materii.add(1);
        profesori.add(new Profesor("2861017468997", "Ionut", "Ionutel", "emailpentrufacultateprof2@facultate.prof.ro", "parolaprof2",materii));
        materii = new ArrayList<>();
        materii.add(2);
        profesori.add(new Profesor("2861003468173", "Codrin", "Bradea", "emailpentrufacultateprof3@facultate.prof.ro", "parolaprof3", materii));
        materii = new ArrayList<>();
        materii.add(3);
        profesori.add(new Profesor("2861031466904", "Alin", "Ionel", "emailpentrufacultateprof4@facultate.prof.ro", "parolaprof4", materii));
        materii = new ArrayList<>();
        materii.add(4);
        profesori.add(new Profesor("2861019468669", "Mircea", "Marcel", "emailpentrufacultateprof5@facultate.prof.ro", "parolaprof5", materii));
        materii = new ArrayList<>();
        materii.add(5);
        profesori.add(new Profesor("2861028466238",  "Diana", "Dana", "emailpentrufacultateprof6@facultate.prof.ro", "parolaprof6", materii));
        materii = new ArrayList<>();
        materii.add(6);
        profesori.add(new Profesor("2371002469419", "Dana", "Diana", "emailpentrufacultateprof7@facultate.prof.ro", "parolaprof7", materii));
        materii = new ArrayList<>();
        materii.add(7);
        profesori.add(new Profesor("2371015468074", "Ion", "Ion", "emailpentrufacultateprof8@facultate.prof.ro", "parolaprof8", materii));

    }

    public ProfesorData() {
        init();
    }

    public Profesor getProfesorDataByEmail(String email) {
        for (Profesor profesor : profesori) {
            if (profesor.getEmail().equals(email)) {
                return profesor;
            }
        }
        return null;
    }
}
