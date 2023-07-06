package lk.directpay.PDF_BackEnd.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public ResponseEntity<String> create() throws DocumentException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,outputStream);
        document.open();

        Paragraph paragraph = new Paragraph("Text Document");
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        document.addAuthor("Dilsha Prasanna");

        document.add(new Paragraph("Date : 2023-07-06"));
        document.add(new Paragraph("Name : Dilsha Prasanna"));
        document.add(new Paragraph("City : Panadura"));

        ListItem elements = new ListItem();
        elements.add(0,new Paragraph("Hello"));
        elements.add(1,new Paragraph("Hello Dilsha"));
        document.add(elements);


        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("test.pdf").build());

        byte[] pdfBytes = outputStream.toByteArray();

        return new ResponseEntity(pdfBytes, headers, HttpStatus.OK);
    }
}
