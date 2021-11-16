package PezentaQrServiceTest;

import com.qrteam.QResent.dto.AttendanceDTO;
import com.qrteam.QResent.dto.MaterieDTO;
import com.qrteam.QResent.dto.StudentDTO;
import com.qrteam.QResent.service.Impl.PrezentaQRServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {IntegrationTestConfig.class})
@AutoConfigureMockMvc
public class PrezentaQrIntegrationTests {

    @Autowired
    PrezentaQRServiceImpl prezentaQRService;

    @Test
    public void shouldGetStudentDisciplines() {
        List<MaterieDTO> materieDTOList = prezentaQRService.getStudentDisciplines("emailpentrufacultatefake1@facultate.stud.ro");
        MaterieDTO materie = materieDTOList.get(0);

        Assertions.assertEquals(0, materie.getId());
        Assertions.assertEquals("Anatomie", materie.getNume());
    }

    @Test
    public void shouldGetAttendance() {
        List<StudentDTO> students = prezentaQRService.getAttendance(0);
        Assertions.assertEquals(0, students.size());

        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setEmail("emailpentrufacultatefake1@facultate.stud.ro");
        attendanceDTO.setCourseId(0);
        attendanceDTO.setPassword("parolafake1");

        StudentDTO studentDTO = prezentaQRService.saveAttendance(attendanceDTO);
        Assertions.assertEquals("Andrei", studentDTO.getFirstName());

        students = prezentaQRService.getAttendance(0);
        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals("Andrei", students.get(0).getFirstName());
    }
}
