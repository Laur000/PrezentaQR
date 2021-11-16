package com.qrteam.QResent.service;

import org.springframework.stereotype.Service;

@Service
public interface GeneratePdfService {
    String print(Integer cursId);

}
