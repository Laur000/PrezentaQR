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

        List<Curs> cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(1));
        cursuri.add(cursData.getCursuri().get(2));
        cursuri.add(cursData.getCursuri().get(3));
        materii.add(new Materie(0, "Anatomie","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: n-avem\nOrar: LUNI 18:00-20:00\n JOI 12:00-15:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(4));
        cursuri.add(cursData.getCursuri().get(5));
        cursuri.add(cursData.getCursuri().get(6));
        materii.add(new Materie(1, "Geografie","Frumoasa materia\nCerinte minime de intrare in examen: 45pct\nBonusuri:2\nOrar: MARTI 18:00-20:00\n JOI 10:00-12:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(7));
        cursuri.add(cursData.getCursuri().get(8));
        cursuri.add(cursData.getCursuri().get(9));

        materii.add(new Materie(2, "Managementul Proiectelor","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: LUNI 11:00-16:00", cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(10));
        cursuri.add(cursData.getCursuri().get(11));
        cursuri.add(cursData.getCursuri().get(12));

        materii.add(new Materie(3, "Istorie","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: 12pct\nOrar: MIERCURI 11:00-16:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(13));
        cursuri.add(cursData.getCursuri().get(14));
        cursuri.add(cursData.getCursuri().get(15));

        materii.add(new Materie(4, "Mate1","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: VINERI 18:00-20:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(16));
        cursuri.add(cursData.getCursuri().get(17));
        cursuri.add(cursData.getCursuri().get(18));

        materii.add(new Materie(5, "Mate2","Frumoasa materia\nCerinte minime de intrare in examen: 60pct\nBonusuri: n-avem\nOrar: LUNI 09:00-12:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(19));
        cursuri.add(cursData.getCursuri().get(20));
        cursuri.add(cursData.getCursuri().get(21));

        materii.add(new Materie(6, "Mate3","Frumoasa materia\nCerinte minime de intrare in examen: 30pct\nBonusuri: 5pct\nOrar: MIERCURI 08:00-11:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(22));
        cursuri.add(cursData.getCursuri().get(23));
        cursuri.add(cursData.getCursuri().get(24));

        materii.add(new Materie(7, "Fizica","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: n-avem\nOrar: MARTI 08:00-10:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(25));
        cursuri.add(cursData.getCursuri().get(26));
        cursuri.add(cursData.getCursuri().get(27));

        materii.add(new Materie(8, "Fizica2","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: LUNI 16:00-18:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(28));
        cursuri.add(cursData.getCursuri().get(29));
        cursuri.add(cursData.getCursuri().get(30));


        materii.add(new Materie(9, "Electrotehnica","Frumoasa materia\nCerinte minime de intrare in examen: 10pct\nBonusuri: 10pct\nOrar: VINERI 11:00-16:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(31));
        cursuri.add(cursData.getCursuri().get(32));
        cursuri.add(cursData.getCursuri().get(33));

        materii.add(new Materie(10, "Electromagnetica","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: VINERI 08:00-11:00",cursuri));
        cursuri =  new ArrayList<>();
        cursuri.add(cursData.getCursuri().get(34));
        cursuri.add(cursData.getCursuri().get(35));
        cursuri.add(cursData.getCursuri().get(36));

        materii.add(new Materie(11, "Chimie","Frumoasa materia\nCerinte minime de intrare in examen: 70pct\nBonusuri: n-avem\nOrar: JOI 07:00-10:00",cursuri));

    }

    public void addMaterie(MaterieDTO materie){
        Materie materieNoua = new Materie(this.materii.size()+1, materie.getNume(), materie.getDetalii(),new ArrayList<>());
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
