package com.qrteam.QResent.databaseMock;
import com.qrteam.QResent.dto.MaterieDTO;
import com.qrteam.QResent.models.Materie;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
public class MaterieData {
    private List<Materie> materii;

    public void init(){
        materii = new ArrayList<>();

        materii.add(new Materie(1, "Anatomie","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: n-avem\nOrar: LUNI 18:00-20:00\n JOI 12:00-15:00"));
        materii.add(new Materie(2, "Geografie","Frumoasa materia\nCerinte minime de intrare in examen: 45pct\nBonusuri:2\nOrar: MARTI 18:00-20:00\n JOI 10:00-12:00"));
        materii.add(new Materie(3, "Managementul Proiectelor","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: LUNI 11:00-16:00"));
        materii.add(new Materie(4, "Istorie","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: 12pct\nOrar: MIERCURI 11:00-16:00"));
        materii.add(new Materie(5, "Mate1","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: VINERI 18:00-20:00"));
        materii.add(new Materie(6, "Mate2","Frumoasa materia\nCerinte minime de intrare in examen: 60pct\nBonusuri: n-avem\nOrar: LUNI 09:00-12:00"));
        materii.add(new Materie(7, "Mate3","Frumoasa materia\nCerinte minime de intrare in examen: 30pct\nBonusuri: 5pct\nOrar: MIERCURI 08:00-11:00"));
        materii.add(new Materie(8, "Fizica","Frumoasa materia\nCerinte minime de intrare in examen: 50pct\nBonusuri: n-avem\nOrar: MARTI 08:00-10:00"));
        materii.add(new Materie(9, "Fizica2","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: LUNI 16:00-18:00"));
        materii.add(new Materie(10, "Electrotehnica","Frumoasa materia\nCerinte minime de intrare in examen: 10pct\nBonusuri: 10pct\nOrar: VINERI 11:00-16:00"));
        materii.add(new Materie(11, "Electromagnetica","Frumoasa materia\nCerinte minime de intrare in examen: 20pct\nBonusuri: n-avem\nOrar: VINERI 08:00-11:00"));
        materii.add(new Materie(12, "Chimie","Frumoasa materia\nCerinte minime de intrare in examen: 70pct\nBonusuri: n-avem\nOrar: JOI 07:00-10:00"));

    }

    public void addMaterie(MaterieDTO materie){
        Materie materieNoua = new Materie(this.materii.size()+1, materie.getNume(), materie.getDetalii());
        this.materii.add(materieNoua);
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
}
