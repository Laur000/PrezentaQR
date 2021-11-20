package com.qrteam.QResent.service;

import com.qrteam.QResent.dto.QrDataDTO;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface GenerateQRService {

    public String getQR(QrDataDTO request) throws IOException;

}
