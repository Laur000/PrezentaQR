package com.qrteam.QResent.service.Impl;

import com.qrteam.QResent.dto.QrDataDTO;
import com.qrteam.QResent.service.GenerateQRService;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class GenerateQRServiceImpl implements GenerateQRService {

    public String getQR(QrDataDTO request) throws IOException {
        File file = QRCode.from(request.getUrl()).withSize(500, 500).file();

        return Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath()));
    }

}
