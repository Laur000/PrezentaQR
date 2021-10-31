package com.qrteam.QResent.service;


import com.qrteam.QResent.dto.ProfesorDTO;
import com.qrteam.QResent.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public interface PrezentaQRService{

    public StudentDTO getStudentData(int id);

    public ProfesorDTO getProfesorData(int id);

//    public AdminDto getStudentData(int id);

}
