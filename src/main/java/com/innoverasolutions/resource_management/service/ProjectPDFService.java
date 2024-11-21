package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.Project;
import com.innoverasolutions.resource_management.repository.ProjectRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ProjectPDFService {

    @Autowired
    private ProjectRepository projectRepository; // Repository to fetch project data

    // Method to generate Project Report PDF
    public byte[] generateProjectReportPdf(Long projectId) throws IOException, DocumentException {
        // Retrieve the project data from the database
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        // Prepare to generate the PDF document
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Add content to the PDF
        document.add(new Paragraph("Project Report"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Project Name: " + project.getName()));
        document.add(new Paragraph("Description: " + project.getDescription()));
        document.add(new Paragraph("Type: " + project.getType()));

        // Add more details as needed
        document.add(new Paragraph("\n")); // Add spacing

        // Close the document and return the generated PDF as a byte array
        document.close();
        return outputStream.toByteArray(); // Return the PDF content as a byte array
    }
}