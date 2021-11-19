package com.qrteam.QResent.service;


import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import com.qrteam.QResent.dto.requests.ProfRequestDTO;
import com.qrteam.QResent.dto.requests.StudentRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrezentaQRService{

    public StudentDTO getStudentData(LoginRequestDTO loginRequestDTO);

    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequestDTO);

    public AdminDTO getAdminData(int id);

    public String saveDiscipline(MaterieDTO materie, String emailProfesor);

    public List<MaterieDTO> getProfDisciplines(ProfRequestDTO request);

    public List<MaterieDTO> getStudentDisciplines(StudentRequestDTO request);

    public List<CursDTO> getCourses(CoursesRequestDTO request);

    public String saveCourse(CursDTO materie, Integer disciplineId);

    public List<StudentDTO> getAttendance(CoursesRequestDTO request);

    public StudentDTO saveAttendance(AttendanceDTO attendance);
}
