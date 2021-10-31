package PezentaQrServiceTest;

import com.qrteam.QResent.databaseMock.StudentData;
import com.qrteam.QResent.dto.LoginRequestDTO;
import com.qrteam.QResent.dto.StudentDTO;
import com.qrteam.QResent.service.Impl.PrezentaQRServiceImpl;
import com.qrteam.QResent.service.PrezentaQRService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrezentaQrUnitTests {
    @Autowired
    StudentData studentData;
    @Autowired
    PrezentaQRService prezentaQRService;

    @Test
    public void shouldReturnStudentData() {
        LoginRequestDTO loginRequest = new LoginRequestDTO();
        loginRequest.setEmail("emailpentrufacultatefake1@facultate.stud.ro");
        loginRequest.setPassword("parolafake1");

        StudentDTO studentDTO = prezentaQRService.getStudentData(loginRequest);
        assertEquals("Andrei", studentDTO.getFirstName());
    }

    @Test
    public void shouldReturnProfData() {
        //TODO
    }

    @Test
    public void shouldReturnNullWithBadPassword() {
        //TODO
    }

    public void dtoMapperTest() {
        //TODO
    }
}
