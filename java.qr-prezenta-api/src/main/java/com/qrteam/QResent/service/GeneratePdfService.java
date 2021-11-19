package com.qrteam.QResent.service;

import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface GeneratePdfService {
    String print(CoursesRequestDTO request);

}
