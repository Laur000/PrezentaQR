package com.qrteam.QResent.service.Impl;


import com.qrteam.QResent.databaseMock.*;
import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.dto.requests.AttendanceRequestDTO;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import com.qrteam.QResent.dto.requests.ProfRequestDTO;
import com.qrteam.QResent.dto.requests.StudentRequestDTO;
import com.qrteam.QResent.models.*;
import com.qrteam.QResent.service.PrezentaQRService;
import com.qrteam.QResent.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public AdminDTO getAdminData(LoginRequestDTO loginRequest) {
        Admin admin = new Admin();
        if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
            return modelMapper.map(admin, AdminDTO.class);
        }
        return null;
    }

    @Override
    public String saveDiscipline(MaterieDTO materie, String email) {
        materieDataRepo.addMaterie(materie);
        Profesor profesor = new Profesor();
        profesor = profesorDataRepo.getProfesorDataByEmail(email);
        materie.setId(materieDataRepo.getMaterii().size()-1);
        profesor.getMaterii().add(materie.getId());
        return materie.getNume();
    }

    @Override
    public String saveCourse(CursDTO cursDTO, Integer disciplineId) {
        cursDTO.setCursId(cursDataRepo.getCursuri().size());
        Materie materie = materieDataRepo.findById(disciplineId);
        if (materie == null) {
            return null;
        } else {
            cursDataRepo.getCursuri().add(modelMapper.map(cursDTO, Curs.class));
            materie.getCursuri().add(cursDTO.getCursId());
            return cursDTO.getNume();
        }
    }

    @Override
    public String deleteCourse(CursDTO cursDTO, Integer disciplineId) {
        Materie materie = materieDataRepo.findById(disciplineId);
        if (materie == null) {
            return null;
        } else {
            cursDataRepo.getCursuri().remove(modelMapper.map(cursDTO, Curs.class));
            materie.getCursuri().remove(cursDTO.getCursId());
            return cursDTO.getNume();
        }
    }

    @Override
    public List<MaterieDTO> getProfDisciplines(ProfRequestDTO request) {
        Profesor profesor = new Profesor();
        profesor = profesorDataRepo.getProfesorDataByEmail(request.getEmail());
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
    public List<MaterieDTO> getStudentDisciplines(StudentRequestDTO request) {
        Student student = studentDataRepo.getStudentDataByEmail(request.getEmail());
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
    public List<CursDTO> getCourses(CoursesRequestDTO request) {
        List<CursDTO> cursDTOList = new ArrayList<>();
        List<Integer> cursuri = materieDataRepo.findById(request.getDisciplineId()).getCursuri();
        if (cursuri != null) {
            for (Integer i : cursuri) {
                Curs curs = cursDataRepo.findCursById(i);
                cursDTOList.add(modelMapper.map(curs, CursDTO.class));
            }
            return cursDTOList;
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAttendance(AttendanceRequestDTO request){
        List<StudentDTO> listaPrezenta = new ArrayList<>();
        List<Student> listaStudenti = cursDataRepo.findCursById(request.getCourseId()).getListaPrezenta();
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
        if (attendance.getSecurityCode() == Constants.SECURITY_CODE && student != null && student.getParola().equals(attendance.getPassword())) {
            cursDataRepo.addAttendance(attendance.getCourseId(),student);
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }

    @Override
    public List<MaterieDTO> getAllDisciplines() {
        return  materieDataRepo.getMaterii().stream()
                .map(element -> modelMapper.map(element, MaterieDTO.class))
                .collect(Collectors.toList());
    }
}