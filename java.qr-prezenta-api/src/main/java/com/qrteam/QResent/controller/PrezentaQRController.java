package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import com.qrteam.QResent.dto.CursDTO;
import com.qrteam.QResent.dto.LoginRequestDTO;
import com.qrteam.QResent.dto.MaterieDTO;
import com.qrteam.QResent.dto.ProfesorDTO;
import com.qrteam.QResent.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class PrezentaQRController {

    @Autowired
    PrezentaQRChoreographer prezentaQRChoreographer;

    @PostMapping("/get-student-data")
    public ResponseEntity<StudentDTO> getStudentData(@RequestBody LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(prezentaQRChoreographer.getStudentData(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/get-profesor-data")
    ResponseEntity<ProfesorDTO> getProfesorData(@RequestBody LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfesorData(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/get-admin-data")
    ResponseEntity<String> getAdminData(@RequestBody LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(prezentaQRChoreographer.getAdminData(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/save-discipline")
    ResponseEntity<String> saveDiscipline(@RequestBody MaterieDTO materie, String emailProfesor) {
        return new ResponseEntity<>(prezentaQRChoreographer.saveDiscipline(materie, emailProfesor), HttpStatus.OK);
    }

    @PostMapping("/get-disciplines")
    ResponseEntity<List<MaterieDTO>> getDisciplines(@RequestBody String email) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfDisciplines(email), HttpStatus.OK);
    }

    @PostMapping("/get-courses")
    ResponseEntity<List<CursDTO>> getCourses(@RequestBody Integer disciplineId) {
        return new ResponseEntity<>(prezentaQRChoreographer.getCourses(disciplineId), HttpStatus.OK);
    }
}
