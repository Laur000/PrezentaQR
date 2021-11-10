package com.qrteam.QResent.service;


import com.qrteam.QResent.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrezentaQRService{

    public StudentDTO getStudentData(LoginRequestDTO loginRequestDTO);

    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequestDTO);

    public AdminDTO getAdminData(int id);

    public String saveDiscipline(MaterieDTO materie, String emailProfesor);

    public List<MaterieDTO> getProfDisciplines(String email);

    public List<MaterieDTO> getStudentDisciplines(String email);

    List<CursDTO> getCourses(Integer disciplineId);
}
