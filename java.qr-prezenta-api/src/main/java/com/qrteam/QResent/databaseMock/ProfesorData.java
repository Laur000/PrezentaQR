package com.qrteam.QResent.databaseMock;
import com.qrteam.QResent.models.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorData {
    private List<Profesor> profesori;

    public void init(){
        profesori = new ArrayList<>();

        profesori.add(new Profesor("6001006035499", "Ion", "Ionel", "emailpentrufacultateprof1@email.com", "parolaprof1"));
        profesori.add(new Profesor("2861017468997", "Ionut", "Ionutel", "emailpentrufacultateprof2@email.com", "parolaprof2"));
        profesori.add(new Profesor("2861003468173", "Codrin", "Bradea", "emailpentrufacultateprof3@email.com", "parolaprof3"));
        profesori.add(new Profesor("2861031466904", "Alin", "Ionel", "emailpentrufacultateprof4@email.com", "parolaprof4"));
        profesori.add(new Profesor("2861019468669", "Mircea", "Marcel", "emailpentrufacultateprof5@email.com", "parolaprof5"));
        profesori.add(new Profesor("2861028466238", "Diana", "Dana", "emailpentrufacultateprof6@email.com", "parolaprof6"));
        profesori.add(new Profesor("2371002469419", "Dana", "Diana", "emailpentrufacultateprof7@email.com", "parolaprof7"));
        profesori.add(new Profesor("2371015468074", "Ion", "Ion", "emailpentrufacultateprof8@email.com", "parolaprof8"));

    }

    public ProfesorData() {
        init();
    }
}
