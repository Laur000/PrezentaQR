package com.qrteam.QResent.service;

import com.qrteam.QResent.dto.QrDataDTO;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;

public interface GenerateQRService {

    public String getQR(QrDataDTO request);

}
