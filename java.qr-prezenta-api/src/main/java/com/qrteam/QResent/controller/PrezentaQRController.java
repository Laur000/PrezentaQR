package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.dto.requests.CoursesRequestDTO;
import com.qrteam.QResent.dto.requests.ProfRequestDTO;
import com.qrteam.QResent.dto.requests.StudentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    ResponseEntity<String> saveDiscipline(@RequestBody SaveDisciplineDTO saveDisciplineDTO) {
        return new ResponseEntity<>(prezentaQRChoreographer.saveDiscipline(saveDisciplineDTO.getMaterie(), saveDisciplineDTO.getEmailProfesor()), HttpStatus.OK);
    }

    @PostMapping("/get-prof-disciplines")
    ResponseEntity<List<MaterieDTO>> getDisciplines(@RequestBody ProfRequestDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfDisciplines(request), HttpStatus.OK);
    }

    @PostMapping("/get-student-disciplines")
    ResponseEntity<List<MaterieDTO>> getStudentDisciplines(@RequestBody StudentRequestDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.getStduentDisciplines(request), HttpStatus.OK);
    }

    @PostMapping("/get-courses")
    ResponseEntity<List<CursDTO>> getProfCourses(@RequestBody CoursesRequestDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfCourses(request), HttpStatus.OK);
    }

    @PostMapping("/save-course")
    ResponseEntity<String> saveCourse(@RequestBody SaveCourseDTO saveCourseDTO) {
        return new ResponseEntity<>(prezentaQRChoreographer.saveCourse(saveCourseDTO.getCursDTO(), saveCourseDTO.getDisciplineId()), HttpStatus.OK);
    }

    @PostMapping("/get-attendance")
    ResponseEntity<List<StudentDTO>> getAttendance(@RequestBody CoursesRequestDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.getAttendance(request), HttpStatus.OK);
    }

    @PostMapping("/save-attendance")
    ResponseEntity<StudentDTO> saveAttendance(@RequestBody AttendanceDTO attendance) {
        return new ResponseEntity<>(prezentaQRChoreographer.saveAttendance(attendance), HttpStatus.OK);
    }

    @PostMapping("/export-attendance-list")
    ResponseEntity<String> print(@RequestBody CoursesRequestDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.print(request), HttpStatus.OK);
    }

    @PostMapping("/get-QR")
    ResponseEntity<String> getQR(@RequestBody QrDataDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.getQR(request), HttpStatus.OK);
    }
}
