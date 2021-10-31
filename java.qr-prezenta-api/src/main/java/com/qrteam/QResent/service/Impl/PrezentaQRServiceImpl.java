package com.qrteam.QResent.service.Impl;


import com.qrteam.QResent.dto.AdminDTO;
import com.qrteam.QResent.dto.ProfesorDTO;
import com.qrteam.QResent.dto.StudentDTO;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.stereotype.Service;

@Service
public class PrezentaQRServiceImpl implements PrezentaQRService {

    @Override
    public StudentDTO getStudentData(int id){
        StudentDTO studentDTO = new StudentDTO();
        return studentDTO;
    }

    @Override
    public ProfesorDTO getProfesorData(int id){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        return profesorDTO;
    }

    @Override
    public AdminDTO getAdminData(int id){
        AdminDTO adminDTO = new AdminDTO();
        return  adminDTO;
    }

}
