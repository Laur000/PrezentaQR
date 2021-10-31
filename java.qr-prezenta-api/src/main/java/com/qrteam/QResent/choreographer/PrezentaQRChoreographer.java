package com.qrteam.QResent.choreographer;

import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrezentaQRChoreographer {

    @Autowired
    PrezentaQRService prezentaQRService;

    public String getStudentData(int id){
        return "Hai ca merge student... " + id;
    }

    public String getProfesorData(int id){
        return "Hai ca merge profesor... " + id;
    }

    public String getAdminData(int id){
        return "Hai ca merge admin... " + id;
    }
}
