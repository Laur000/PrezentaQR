package com.qrteam.QResent.service;


import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.dto.requests.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrezentaQRService {

    StudentDTO getStudentData(LoginRequestDTO loginRequestDTO);

    ProfesorDTO getProfesorData(LoginRequestDTO loginRequestDTO);

    AdminDTO getAdminData(LoginRequestDTO loginRequestDTO);

    String saveDiscipline(MaterieDTO materie, String emailProfesor);

    List<MaterieDTO> getProfDisciplines(ProfRequestDTO request);

    List<MaterieDTO> getStudentDisciplines(StudentRequestDTO request);

    List<CursDTO> getCourses(DisciplineRequestDto request);

    String saveCourse(CursDTO materie, Integer disciplineId);

    String deleteCourse(CursDTO materie, Integer disciplineId);

    List<StudentDTO> getAttendance(AttendanceRequestDTO request);

    StudentDTO saveAttendance(AttendanceDTO attendance);

    List<MaterieDTO> getAllDisciplines();
}
