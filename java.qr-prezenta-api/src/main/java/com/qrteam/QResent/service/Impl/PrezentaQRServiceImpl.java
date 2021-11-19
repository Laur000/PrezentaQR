package com.qrteam.QResent.service.Impl;


import com.qrteam.QResent.databaseMock.CursData;
import com.qrteam.QResent.databaseMock.MaterieData;
import com.qrteam.QResent.databaseMock.ProfesorData;
import com.qrteam.QResent.databaseMock.StudentData;
import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.models.Curs;
import com.qrteam.QResent.models.Materie;
import com.qrteam.QResent.models.Profesor;
import com.qrteam.QResent.models.Student;
import com.qrteam.QResent.service.PrezentaQRService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    CursData cursDataRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public StudentDTO getStudentData(LoginRequestDTO loginRequest) {
        Student student = studentDataRepo.getStudentDataByEmail(loginRequest.getEmail());
        if (student != null && student.getParola().equals(loginRequest.getPassword())) {
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }

    @Override
    public ProfesorDTO getProfesorData(LoginRequestDTO loginRequest) {
        Profesor profesor = profesorDataRepo.getProfesorDataByEmail(loginRequest.getEmail());
        if (profesor != null && profesor.getParola().equals(loginRequest.getPassword())) {
            return modelMapper.map(profesor, ProfesorDTO.class);
        }
        return null;
    }

    @Override
    public AdminDTO getAdminData(int id) {
        AdminDTO adminDTO = new AdminDTO();
        return adminDTO;
    }

    @Override
    public String saveDiscipline(MaterieDTO materie, String email) {
        materieDataRepo.addMaterie(materie);
        Profesor profesor = new Profesor();
        profesor = profesorDataRepo.getProfesorDataByEmail(email);
        materie.setId(profesor.getMaterii().size());
        profesor.getMaterii().add(materie.getId());
        return materie.getNume();
    }

    @Override
    public String saveCourse(CursDTO cursDTO, Integer disciplineId) {
        Materie materie = materieDataRepo.findById(disciplineId);
        if (materie == null) {
            return null;
        } else {
            cursDTO.setCursId(materie.getCursuri().size());
            materie.getCursuri().add(modelMapper.map(cursDTO, Curs.class));
            return cursDTO.getNume();
        }
    }

    @Override
    public List<MaterieDTO> getProfDisciplines(String email) {
        Profesor profesor = new Profesor();
        profesor = profesorDataRepo.getProfesorDataByEmail(email);
        List<MaterieDTO> materii = new ArrayList<>();

        for (Integer id : profesor.getMaterii()) {
            MaterieDTO materieDTO = new MaterieDTO();
            Materie mat = new Materie();
            mat = materieDataRepo.findMaterieById(id);

            materieDTO.setId(mat.getId());
            materieDTO.setNume(mat.getNume());
            materieDTO.setDetalii(mat.getDetalii());
            materieDTO.setCursuri(new ArrayList<CursDTO>());
            materii.add(materieDTO);
        }
        return materii;
    }

    @Override
    public List<MaterieDTO> getStudentDisciplines(String email) {
        Student student = studentDataRepo.getStudentDataByEmail(email);
        if (student != null) {
            List<MaterieDTO> materii = new ArrayList<>();

            for (Integer id : student.getMaterii()) {
                MaterieDTO materieDTO = new MaterieDTO();
                Materie mat = materieDataRepo.findMaterieById(id);
                materieDTO.setId(mat.getId());
                materieDTO.setNume(mat.getNume());
                materieDTO.setDetalii(mat.getDetalii());
                materieDTO.setCursuri(new ArrayList<>());
                materii.add(materieDTO);
            }
            return materii;
        }
        return null;
    }

    @Override
    public List<CursDTO> getCourses(Integer disciplineId) {
        List<CursDTO> cursDTOList = new ArrayList<>();
        Materie materie = materieDataRepo.findById(disciplineId);
        if (materie != null) {
            for (Curs curs : materie.getCursuri()) {
                cursDTOList.add(modelMapper.map(curs, CursDTO.class));
            }
            return cursDTOList;
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAttendance(Integer courseId){
        List<StudentDTO> listaPrezenta = new ArrayList<>();
        List<Student> listaStudenti = cursDataRepo.findCursById(courseId).getListaPrezenta();
        if (listaStudenti != null) {
            for (Student student : listaStudenti) {
                listaPrezenta.add(modelMapper.map(student, StudentDTO.class));
            }
            return listaPrezenta;
        }
        return null;
    }

    @Override
    public StudentDTO saveAttendance(AttendanceDTO attendance){
        Student student = studentDataRepo.getStudentDataByEmail(attendance.getEmail());
        if (student != null && student.getParola().equals(attendance.getPassword())) {
            cursDataRepo.addAttendance(attendance.getCourseId(),student);
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }
}