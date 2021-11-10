package com.qrteam.QResent.choreographer;

import com.qrteam.QResent.dto.CursDTO;
import com.qrteam.QResent.dto.LoginRequestDTO;
import com.qrteam.QResent.dto.MaterieDTO;
import com.qrteam.QResent.dto.ProfesorDTO;
import com.qrteam.QResent.dto.StudentDTO;
import com.qrteam.QResent.models.Materie;
import com.qrteam.QResent.service.PrezentaQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrezentaQRChoreographer {

    @Autowired
    PrezentaQRService prezentaQRService;

    public StudentDTO getStudentData(LoginRequestDTO loginRequest){
        StudentDTO response = prezentaQRService.getStudentData(loginRequest);
        return response;
    }

    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequest){
        ProfesorDTO response = prezentaQRService.getProfesorData(loginRequest);
        return response;
    }

    public String getAdminData(LoginRequestDTO loginRequest){
        return "Hai ca merge admin...   email " + loginRequest.getEmail() +" si parola:"+ loginRequest.getPassword();
    }

    public String saveDiscipline(MaterieDTO materie, String emailProfesor){
        return prezentaQRService.saveDiscipline(materie, emailProfesor);
    }

    public List<MaterieDTO> getProfDisciplines(String email){
        return prezentaQRService.getProfDisciplines(email);
    }

    public List<CursDTO> getProfCourses(Integer disciplineId) {
        return prezentaQRService.getCourses(disciplineId);
    }
}
