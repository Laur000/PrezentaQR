package com.qrteam.QResent.service;

import com.qrteam.QResent.dto.QrDataDTO;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;

import java.io.IOException;

public interface GenerateQRService {

    public String getQR(QrDataDTO request) throws IOException;

}
