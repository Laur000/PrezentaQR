package com.qrteam.QResent.service.Impl;


import com.qrteam.QResent.databaseMock.ProfesorData;
import com.qrteam.QResent.databaseMock.StudentData;
import com.qrteam.QResent.dto.AdminDTO;
import com.qrteam.QResent.dto.LoginRequestDTO;
import com.qrteam.QResent.dto.ProfesorDTO;
import com.qrteam.QResent.dto.StudentDTO;
import com.qrteam.QResent.models.Profesor;
import com.qrteam.QResent.models.Student;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrezentaQRServiceImpl implements PrezentaQRService {

    @Autowired
    StudentData studentDataRepo;

    @Autowired
    ProfesorData profesorDataRepo;

    @Override
    public StudentDTO getStudentData(LoginRequestDTO loginRequest){
        Student student = studentDataRepo.getStudentDataByEmail(loginRequest.getEmail());
        if (student != null && student.getParola().equals(loginRequest.getPassword())) {
            return toStudentDto(student);
        }
        return null;
    }

    @Override
    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequest){
        Profesor profesor = profesorDataRepo.getProfesorDataByEmail(loginRequest.getEmail());
        if (profesor != null && profesor.getParola().equals(loginRequest.getPassword())) {
            return toProfesorDto(profesor);
        }
        return null;
    }

    @Override
    public AdminDTO getAdminData(int id){
        AdminDTO adminDTO = new AdminDTO();
        return  adminDTO;
    }

    private StudentDTO toStudentDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setCnp(student.getCnp());
        dto.setEmail(student.getEmail());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setYearOfStudy(student.getYearOfStudy());
        return dto;
    }

    private ProfesorDTO toProfesorDto(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setCnp(profesor.getCnp());
        dto.setEmail(profesor.getEmail());
        dto.setFirstName(profesor.getFirstName());
        dto.setLastName(profesor.getLastName());
        return dto;
    }
}
