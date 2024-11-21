package com.innoverasolutions.resource_management.controller;
import com.innoverasolutions.resource_management.service.ProjectPDFService;
import com.innoverasolutions.resource_management.service.ProjectPDFService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
//
//@Controller
//public class projectPDFController {
//
//    @Autowired
//    private projectPDFController projectPDFService; // Inject the service that handles PDF generation
//
//    @GetMapping("/project/download/{id}")
//    public ResponseEntity<byte[]> downloadProjectPdf(@PathVariable Long id) throws IOException, DocumentException {
//        byte[] pdfContent = projectPDFService.generateProjectReportPdf(id); // Call the service method to generate the PDF
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentDispositionFormData("attachment", "project_" + id + ".pdf"); // Adjusted filename for projects
//        return ResponseEntity.ok().headers(headers).body(pdfContent); // Return the PDF as a response
//    }
//
//
//}


@Controller
public class projectPDFController {

    @Autowired
    private ProjectPDFService projectPDFService; // Corrected the type to ProjectPDFService

    @GetMapping("/project/download/{id}")
    public ResponseEntity<byte[]> downloadProjectPdf(@PathVariable Long id) throws IOException, DocumentException {
        byte[] pdfContent = projectPDFService.generateProjectReportPdf(id); // Call the service method to generate the PDF
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "project_" + id + ".pdf"); // Adjusted filename for projects
        return ResponseEntity.ok().headers(headers).body(pdfContent); // Return the PDF as a response
    }
}