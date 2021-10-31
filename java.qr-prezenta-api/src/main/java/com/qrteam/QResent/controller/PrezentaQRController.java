package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import com.qrteam.QResent.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class PrezentaQRController {

    @Autowired
    PrezentaQRChoreographer prezentaQRChoreographer;

    @PostMapping("/get-student-data")
    public ResponseEntity<String> getStudentData(@RequestBody LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(prezentaQRChoreographer.getStudentData(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/get-profesor-data")
    ResponseEntity<String> getProfesorData(@RequestBody LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfesorData(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/get-admin-data")
    ResponseEntity<String> getAdminData(@RequestBody LoginRequestDTO loginRequest) {
        return new ResponseEntity<>(prezentaQRChoreographer.getAdminData(loginRequest), HttpStatus.OK);
    }


}
