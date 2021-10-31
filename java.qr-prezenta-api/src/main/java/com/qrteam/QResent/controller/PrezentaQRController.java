package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrezentaQRController {

    @Autowired
    PrezentaQRChoreographer prezentaQRChoreographer;

    @PostMapping("/qr-data")
    ResponseEntity<String> getQRData(@RequestBody int id) {
        return new ResponseEntity<>(prezentaQRChoreographer.getQRData(id), HttpStatus.OK);
    }


}
