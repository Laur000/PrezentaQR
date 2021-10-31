package com.qrteam.QResent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class QResentApplication {

	public static void main(String[] args) {
		SpringApplication.run(QResentApplication.class, args);
	}

}
