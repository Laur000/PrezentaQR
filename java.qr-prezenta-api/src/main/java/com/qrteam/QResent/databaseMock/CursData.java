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




    }
}
