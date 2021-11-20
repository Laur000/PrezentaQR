package com.qrteam.QResent.databaseMock;
import com.qrteam.QResent.dto.MaterieDTO;
import com.qrteam.QResent.models.Curs;
import com.qrteam.QResent.models.Materie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Repository
public class MaterieData {

    private List<Materie> materii;

    public void init(){
        materii = new ArrayList<>();
        CursData cursData = new CursData();


        List<Integer> cursuri = new ArrayList<>();
        cursuri.add(0);
        cursuri.add(1);
        cursuri.add(2);
        cursuri.add(3);
        materii.add(new Materie(0, "Anatomie","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: n-avem\nOrar: LUNI 18:00-20:00\n JOI 12:00-15:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(4);
        cursuri.add(5);
        cursuri.add(6);
        materii.add(new Materie(1, "Geografie","Frumoasa materia\nCerinte minime de intrare in examen: 45pct\nBonusuri:2\nOrar: MARTI 18:00-20:00\n JOI 10:00-12:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(7);
        cursuri.add(8);
        cursuri.add(9);
        materii.add(new Materie(2, "Managementul Proiectelor","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: LUNI 11:00-16:00", cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(10);
        cursuri.add(11);
        cursuri.add(12);
        materii.add(new Materie(3, "Istorie","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: 12pct\nOrar: MIERCURI 11:00-16:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(13);
        cursuri.add(14);
        cursuri.add(15);
        materii.add(new Materie(4, "Mate1","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: VINERI 18:00-20:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(16);
        cursuri.add(17);
        cursuri.add(18);
        materii.add(new Materie(5, "Mate2","Frumoasa materia\nCerinte minime de intrare in examen: 60pct\nBonusuri: n-avem\nOrar: LUNI 09:00-12:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(19);
        cursuri.add(20);
        cursuri.add(21);
        materii.add(new Materie(6, "Mate3","Frumoasa materia\nCerinte minime de intrare in examen: 30pct\nBonusuri: 5pct\nOrar: MIERCURI 08:00-11:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(22);
        cursuri.add(23);
        cursuri.add(24);
        materii.add(new Materie(7, "Fizica","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: n-avem\nOrar: MARTI 08:00-10:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(25);
        cursuri.add(26);
        cursuri.add(27);
        materii.add(new Materie(8, "Fizica2","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: LUNI 16:00-18:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(28);
        cursuri.add(29);
        cursuri.add(30);
        materii.add(new Materie(9, "Electrotehnica","Frumoasa materia\nCerinte minime de intrare in examen: 10pct\nBonusuri: 10pct\nOrar: VINERI 11:00-16:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(31);
        cursuri.add(32);
        cursuri.add(33);
        materii.add(new Materie(10, "Electromagnetica","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: VINERI 08:00-11:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(34);
        cursuri.add(35);
        cursuri.add(36);
        materii.add(new Materie(11, "Chimie","Frumoasa materia\nCerinte minime de intrare in examen: 70pct\nBonusuri: n-avem\nOrar: JOI 07:00-10:00",cursuri));

    }

    public void addMaterie(MaterieDTO materie){
        Materie materieNoua = new Materie(this.materii.size(), materie.getNume(), materie.getDetalii(),new ArrayList<>());
        this.materii.add(materieNoua);
    }

    public Materie findMaterieById(Integer id){
        for(Materie m: this.materii){
            if(id == m.getId()){
                return m;
            }
        }
        return null;
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public void setMaterii(List<Materie> materii) {
        this.materii = materii;
    }

    public MaterieData() {
        init();
    }

    public Materie findById(Integer disciplineId) {
        for (Materie materie: materii) {
            if (Objects.equals(materie.getId(), disciplineId)) {
                return materie;
            }
        }
        return null;
    }
}
