package com.qrteam.QResent.service.Impl;

import com.qrteam.QResent.dto.requests.QRRequestDTO;
import com.qrteam.QResent.service.GenerateQRService;
import com.qrteam.QResent.utils.Constants;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Service
public class GenerateQRServiceImpl implements GenerateQRService {

    public String getQR(QRRequestDTO request) throws IOException {

        Constants.SECURITY_CODE = 100000 + (long) (Math.random() * (999999 - 100000));

        Constants.COURSE_ID = request.getCourseId();

        File file = QRCode.from(Constants.URL).withSize(500, 500).file();

        return Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath()));
    }

}
