package lk.directpay.PDF_BackEnd.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.ResponseEntity;
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

        return null;
    }
}
