package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PrezentaQRController {

    @Autowired
    PrezentaQRChoreographer prezentaQRChoreographer;

    @PostMapping("/get-student-data")
    ResponseEntity<String> getStudentData(@RequestBody String id) {
        return new ResponseEntity<>(prezentaQRChoreographer.getStudentData(id), HttpStatus.OK);
    }

    @PostMapping("/get-profesor-data")
    ResponseEntity<String> getProfesorData(@RequestBody String id) {
        return new ResponseEntity<>(prezentaQRChoreographer.getProfesorData(id), HttpStatus.OK);
    }

    @PostMapping("/get-admin-data")
    ResponseEntity<String> getAdminData(@RequestBody String id) {
        return new ResponseEntity<>(prezentaQRChoreographer.getAdminData(id), HttpStatus.OK);
    }


}
