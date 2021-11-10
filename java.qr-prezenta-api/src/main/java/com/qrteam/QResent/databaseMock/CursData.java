package com.qrteam.QResent.databaseMock;

import com.qrteam.QResent.models.Curs;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class CursData {
    private List<Curs> cursuri;

    public void init(){
        cursuri = new ArrayList<>();

        cursuri.add(new Curs(0, "CursAstronomie1", "detalii"));
        cursuri.add(new Curs(1, "CursAnatomie1", "detalii"));
        cursuri.add(new Curs(2, "CursAnatomie2", "detalii"));
        cursuri.add(new Curs(3, "CursAnatomie3", "detalii"));
        cursuri.add(new Curs(4, "CursGeografie1", "detalii"));
        cursuri.add(new Curs(5, "CursGeografie2", "detalii"));
        cursuri.add(new Curs(6, "CursGeografie3", "detalii"));
        cursuri.add(new Curs(7, "CursMP1", "detalii"));
        cursuri.add(new Curs(8, "CursMP2", "detalii"));
        cursuri.add(new Curs(9, "CursMP3", "detalii"));
        cursuri.add(new Curs(10, "CursIstorie1", "detalii"));
        cursuri.add(new Curs(11, "CursIstorie2", "detalii"));
        cursuri.add(new Curs(12, "CursIstorie3", "detalii"));
        cursuri.add(new Curs(13, "CursMate1_1", "detalii"));
        cursuri.add(new Curs(14, "CursMate1_2", "detalii"));
        cursuri.add(new Curs(15, "CursMate1_3", "detalii"));
        cursuri.add(new Curs(16, "CursMate2_1", "detalii"));
        cursuri.add(new Curs(17, "CursMate2_2", "detalii"));
        cursuri.add(new Curs(18, "CursMate2_3", "detalii"));
        cursuri.add(new Curs(19, "CursMate3_1", "detalii"));
        cursuri.add(new Curs(20, "CursMate3_2", "detalii"));
        cursuri.add(new Curs(21, "CursMate3_3", "detalii"));
        cursuri.add(new Curs(22, "CursFizica1", "detalii"));
        cursuri.add(new Curs(23, "CursFizica2", "detalii"));
        cursuri.add(new Curs(24, "CursFizica3", "detalii"));
        cursuri.add(new Curs(25, "CursFizica2_1", "detalii"));
        cursuri.add(new Curs(26, "CursFizica2_2", "detalii"));
        cursuri.add(new Curs(27, "CursFizica2_3", "detalii"));
        cursuri.add(new Curs(28, "CursElectrotehnica1", "detalii"));
        cursuri.add(new Curs(29, "CursElectrotehnica2", "detalii"));
        cursuri.add(new Curs(30, "CursElectrotehnica3", "detalii"));
        cursuri.add(new Curs(31, "CursElectromagnetica1", "detalii"));
        cursuri.add(new Curs(32, "CursElectromagnetica2", "detalii"));
        cursuri.add(new Curs(33, "CursElectromagnetica3", "detalii"));
        cursuri.add(new Curs(34, "CursChimie1", "detalii"));
        cursuri.add(new Curs(35, "CursChimie2", "detalii"));
        cursuri.add(new Curs(36, "CursChimie3", "detalii"));


    }
    public CursData() {
        init();
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }
}
