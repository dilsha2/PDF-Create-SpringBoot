package lk.directpay.PDF_BackEnd.controller;

import com.itextpdf.text.DocumentException;
import lk.directpay.PDF_BackEnd.service.PdfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping
    public ResponseEntity<String> generatePdf() throws DocumentException {
        return pdfService.create();
    }
}
