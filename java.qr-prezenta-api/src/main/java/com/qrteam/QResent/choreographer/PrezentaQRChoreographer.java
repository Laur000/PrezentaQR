package com.qrteam.QResent.choreographer;

import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.dto.requests.AttendanceRequestDTO;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import com.qrteam.QResent.dto.requests.ProfRequestDTO;
import com.qrteam.QResent.dto.requests.StudentRequestDTO;
import com.qrteam.QResent.service.GeneratePdfService;
import com.qrteam.QResent.service.GenerateQRService;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class PrezentaQRChoreographer {

    @Autowired
    PrezentaQRService prezentaQRService;

    @Autowired
    GeneratePdfService generatePdfService;

    @Autowired
    GenerateQRService generateQRService;

    public StudentDTO getStudentData(LoginRequestDTO loginRequest) {
        StudentDTO response = prezentaQRService.getStudentData(loginRequest);
        return response;
    }

    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequest) {
        ProfesorDTO response = prezentaQRService.getProfesorData(loginRequest);
        return response;
    }

    public AdminDTO getAdminData(LoginRequestDTO loginRequest) {
        AdminDTO respone = prezentaQRService.getAdminData(loginRequest);
        return respone;
    }

    public String saveDiscipline(MaterieDTO materie, String emailProfesor) {
        return prezentaQRService.saveDiscipline(materie, emailProfesor);
    }

    public List<MaterieDTO> getProfDisciplines(ProfRequestDTO request) {
        return prezentaQRService.getProfDisciplines(request);
    }

    public List<MaterieDTO> getStduentDisciplines(StudentRequestDTO request) {
        return prezentaQRService.getStudentDisciplines(request);
    }

    public List<CursDTO> getProfCourses(CoursesRequestDTO request) {
        return prezentaQRService.getCourses(request);
    }

    public String saveCourse(CursDTO cursDTO, Integer disciplineId) {
        return prezentaQRService.saveCourse(cursDTO, disciplineId);
    }

    public List<StudentDTO> getAttendance(AttendanceRequestDTO request) {
        return prezentaQRService.getAttendance(request);
    }

    public StudentDTO saveAttendance(AttendanceDTO attendance) {
        return prezentaQRService.saveAttendance(attendance);
    }

    public String print(CoursesRequestDTO request) {
        return generatePdfService.print(request);
    }

    public String getQR(QrDataDTO request) throws IOException {
        return generateQRService.getQR(request);
    }
}