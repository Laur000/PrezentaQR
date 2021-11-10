package com.qrteam.QResent.service.Impl;


import com.qrteam.QResent.databaseMock.MaterieData;
import com.qrteam.QResent.databaseMock.ProfesorData;
import com.qrteam.QResent.databaseMock.StudentData;
import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.models.Profesor;
import com.qrteam.QResent.models.Student;
import com.qrteam.QResent.service.PrezentaQRService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrezentaQRServiceImpl implements PrezentaQRService {

    @Autowired
    StudentData studentDataRepo;

    @Autowired
    ProfesorData profesorDataRepo;

    @Autowired
    MaterieData materieDataRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public StudentDTO getStudentData(LoginRequestDTO loginRequest){
        Student student = studentDataRepo.getStudentDataByEmail(loginRequest.getEmail());
        if (student != null && student.getParola().equals(loginRequest.getPassword())) {
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }

    @Override
    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequest){
        Profesor profesor = profesorDataRepo.getProfesorDataByEmail(loginRequest.getEmail());
        if (profesor != null && profesor.getParola().equals(loginRequest.getPassword())) {
            return modelMapper.map(profesor, ProfesorDTO.class);
        }
        return null;
    }

    @Override
    public AdminDTO getAdminData(int id){
        AdminDTO adminDTO = new AdminDTO();
        return  adminDTO;
    }

    @Override
    public String saveDiscipline(MaterieDTO materie){
        materieDataRepo.addMaterie(materie);
        return materie.getNume();
    }

    @Override
    public List<MaterieDTO> getDisciplines(String cnp){

    }
}
