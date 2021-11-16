package PezentaQrServiceTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan(basePackages = "com.qrteam")
@EntityScan(basePackages = "com.qrteam.QResent.models")
public class IntegrationTestConfig {

}
