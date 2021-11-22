package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import com.qrteam.QResent.dto.*;
import com.qrteam.QResent.dto.requests.*;
import com.qrteam.QResent.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    ResponseEntity<AdminDTO> getAdminData(@RequestBody LoginRequestDTO loginRequest) {
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
    ResponseEntity<List<CursDTO>> getProfCourses(@RequestBody DisciplineRequestDto request) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfCourses(request), HttpStatus.OK);
    }

    @PostMapping("/get-all-disciplines")
    ResponseEntity<List<MaterieDTO>> getAlldisciplines() {
        return new ResponseEntity<>(prezentaQRChoreographer.getAllDisciplines(), HttpStatus.OK);
    }

    @PostMapping("/save-course")
    ResponseEntity<String> saveCourse(@RequestBody SaveCourseDTO saveCourseDTO) {
        return new ResponseEntity<>(prezentaQRChoreographer.saveCourse(saveCourseDTO.getCursDTO(), saveCourseDTO.getDisciplineId()), HttpStatus.OK);
    }

    @PostMapping("/delete-course")
    ResponseEntity<String> deleteCourse(@RequestBody SaveCourseDTO request) {
        return new ResponseEntity<>(prezentaQRChoreographer.deleteCourse(request.getCursDTO(), request.getDisciplineId()), HttpStatus.OK);
    }

    @PostMapping("/get-attendance")
    ResponseEntity<List<StudentDTO>> getAttendance(@RequestBody AttendanceRequestDTO request) {
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
    ResponseEntity<String> getQR(@RequestBody QRRequestDTO request) throws IOException {
        return new ResponseEntity<>(prezentaQRChoreographer.getQR(request), HttpStatus.OK);
    }

    @PostMapping("/get-attendance-data")
    ResponseEntity<QrDataDTO> getAttendanceData() throws IOException {
        return new ResponseEntity<>(new QrDataDTO(Constants.COURSE_ID,Constants.SECURITY_CODE), HttpStatus.OK);
    }
}
