package com.qrteam.QResent.choreographer;

import com.qrteam.QResent.dto.LoginRequestDTO;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrezentaQRChoreographer {

    @Autowired
    PrezentaQRService prezentaQRService;

    public String getStudentData(LoginRequestDTO loginRequest){
        return "Hai ca merge student...  email " + loginRequest.getEmail() +" si parola:"+ loginRequest.getPassword();
    }

    public String getProfesorData(LoginRequestDTO loginRequest){
        return "Hai ca merge profesor...   email " + loginRequest.getEmail() +" si parola:"+ loginRequest.getPassword();
    }

    public String getAdminData(LoginRequestDTO loginRequest){
        return "Hai ca merge admin...   email " + loginRequest.getEmail() +" si parola:"+ loginRequest.getPassword();
    }
}
