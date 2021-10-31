package com.qrteam.QResent.service.Impl;


import com.qrteam.QResent.databaseMock.StudentData;
import com.qrteam.QResent.dto.AdminDTO;
import com.qrteam.QResent.dto.LoginRequestDTO;
import com.qrteam.QResent.dto.ProfesorDTO;
import com.qrteam.QResent.dto.StudentDTO;
import com.qrteam.QResent.models.Student;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrezentaQRServiceImpl implements PrezentaQRService {

    @Autowired
    StudentData studentDataRepo;

    @Override
    public StudentDTO getStudentData(LoginRequestDTO loginRequest){
        Student student = studentDataRepo.getStudentDataByEmail(loginRequest.getEmail());
        if (student != null && student.getParola().equals(loginRequest.getPassword())) {
            return toStudentDto(student);
        }
        return null;
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

    private StudentDTO toStudentDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setCnp(student.getCnp());
        dto.setEmail(student.getEmail());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setYearOfStudy(student.getYearOfStudy());
        return dto;
    }
}
