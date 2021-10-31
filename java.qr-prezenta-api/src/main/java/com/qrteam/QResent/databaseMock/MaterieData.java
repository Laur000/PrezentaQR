package com.qrteam.QResent.databaseMock;
import com.qrteam.QResent.models.Materie;


import java.util.ArrayList;
import java.util.List;

public class MaterieData {
    private List<Materie> materii;

    public void init(){
        materii = new ArrayList<>();

        materii.add(new Materie(1, "Anatomie"));
        materii.add(new Materie(2, "Geografie"));
        materii.add(new Materie(3, "Managementul Proiectelor"));
        materii.add(new Materie(4, "Istorie"));
        materii.add(new Materie(5, "Mate1"));
        materii.add(new Materie(6, "Mate2"));
        materii.add(new Materie(7, "Mate3"));
        materii.add(new Materie(8, "Fizica"));
        materii.add(new Materie(9, "Fizica2"));
        materii.add(new Materie(10, "Electrotehnica"));
        materii.add(new Materie(11, "Electromagnetica"));
        materii.add(new Materie(12, "Chimie"));

    }

    public MaterieData() {
        init();
    }
}
