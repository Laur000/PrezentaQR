package com.qrteam.QResent.service;

import com.qrteam.QResent.dto.QrDataDTO;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import com.qrteam.QResent.dto.requests.QRRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface GenerateQRService {

    public String getQR(QRRequestDTO request) throws IOException;

}
