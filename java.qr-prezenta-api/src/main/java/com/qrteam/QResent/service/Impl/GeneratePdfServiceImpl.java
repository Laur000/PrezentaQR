package com.qrteam.QResent.service.Impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.qrteam.QResent.databaseMock.CursData;
import com.qrteam.QResent.exeptions.CursNotFoundExeption;
import com.qrteam.QResent.models.Curs;
import com.qrteam.QResent.models.Student;
import com.qrteam.QResent.service.GeneratePdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class GeneratePdfServiceImpl implements GeneratePdfService {

    private final static String PDF_PATH = "src/main/resources/ListaPrezenta.pdf";

    @Autowired
    CursData cursDataRepo;

    @Override
    public String print(Integer cursId) {
        try {
            Curs curs = cursDataRepo.getCursById(cursId);
            //Curs curs = new CursData().getCursById(id);
            if (curs != null) {
                Document document = new Document(PageSize.A4);
                PdfWriter.getInstance(document, new FileOutputStream(PDF_PATH));
                document.open();
                Paragraph title = new Paragraph("Lista de prezenta\n");
                title.setAlignment(Element.ALIGN_CENTER);
                Paragraph cursTitle = new Paragraph(curs.getNume() + "\n");
                cursTitle.setAlignment(Element.ALIGN_CENTER);
                Paragraph space = new Paragraph(" ");

                PdfPTable table = new PdfPTable(1);
                PdfPCell c1 = new PdfPCell(new Paragraph("Studenti"));

                table.addCell(c1);

                for (Student student : curs.getListaPrezenta()) {
                    PdfPCell stud = new PdfPCell(new Paragraph(student.getFirstName() + " "
                            + student.getLastName()));
                    table.addCell(stud);
                }

                document.add(title);
                document.add(cursTitle);
                document.add(space);
                document.add(table);
                document.close();


                try {
                    byte[] fileContent = Files.readAllBytes(Paths.get(PDF_PATH));
                    return Base64.getEncoder().encodeToString(fileContent);
                } catch (IOException e) {
                    System.err.println(e);
                }

            } else {
                throw new CursNotFoundExeption("Nu exista curs cu id ul " + cursId);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (DocumentException e) {
            System.err.println(e);
        } catch (CursNotFoundExeption e) {
            System.err.println(e);
        }

        return null;
    }

}
