package com.qrteam.QResent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.qrteam")
public class QResentApplication {

	public static void main(String[] args) {
		SpringApplication.run(QResentApplication.class, args);
	}
}
