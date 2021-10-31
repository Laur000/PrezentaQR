package com.qrteam.QResent.controller;


import com.qrteam.QResent.choreographer.PrezentaQRChoreographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrezentaQRController {

    @Autowired
    PrezentaQRChoreographer prezentaQRChoreographer;

}
