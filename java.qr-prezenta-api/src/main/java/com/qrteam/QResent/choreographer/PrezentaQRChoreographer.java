package com.qrteam.QResent.choreographer;

import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.models.Student;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrezentaQRChoreographer {

    @Autowired
    PrezentaQRService prezentaQRService;

    public StudentDTO getStudentData(LoginRequestDTO loginRequest) {
        StudentDTO response = prezentaQRService.getStudentData(loginRequest);
        return response;
    }

    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequest) {
        ProfesorDTO response = prezentaQRService.getProfesorData(loginRequest);
        return response;
    }

    public String getAdminData(LoginRequestDTO loginRequest) {
        return "Hai ca merge admin...   email " + loginRequest.getEmail() + " si parola:" + loginRequest.getPassword();
    }

    public String saveDiscipline(MaterieDTO materie, String emailProfesor) {
        return prezentaQRService.saveDiscipline(materie, emailProfesor);
    }

    public List<MaterieDTO> getProfDisciplines(String email) {
        return prezentaQRService.getProfDisciplines(email);
    }

    public List<MaterieDTO> getStduentDisciplines(String email) {
        return prezentaQRService.getStudentDisciplines(email);
    }

    public List<CursDTO> getProfCourses(Integer disciplineId) {
        return prezentaQRService.getCourses(disciplineId);
    }

    public String saveCourse(CursDTO cursDTO, Integer disciplineId) {
        return prezentaQRService.saveCourse(cursDTO, disciplineId);
    }

    public List<StudentDTO> getAttendance(Integer courseId) {
        return prezentaQRService.getAttendance(courseId);
    }

    public StudentDTO saveAttendance(AttendanceDTO attendance){
        return prezentaQRService.saveAttendance(attendance);
    }
}