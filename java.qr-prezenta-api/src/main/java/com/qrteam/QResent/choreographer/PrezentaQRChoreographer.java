package com.qrteam.QResent.choreographer;

import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;

public class PrezentaQRChoreographer {

    @Autowired
    PrezentaQRService prezentaQRService;

    public String getQRData(int id){
        return "Hai ca merge... " + id;
    }
}
