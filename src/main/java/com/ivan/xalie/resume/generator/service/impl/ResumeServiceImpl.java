package com.ivan.xalie.resume.generator.service.impl;

import com.itextpdf.html2pdf.HtmlConverter;
import com.ivan.xalie.resume.generator.dto.Resume;
import com.ivan.xalie.resume.generator.service.model.ResumeService;
import com.ivan.xalie.resume.generator.service.model.ResumeToHtmlTransformerService;
import com.ivan.xalie.resume.generator.service.model.StyleService;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;

public class ResumeServiceImpl implements ResumeService {

    private final ResumeToHtmlTransformerService transformerService;
    private final StyleService styleService;

    public ResumeServiceImpl(ResumeToHtmlTransformerService transformerService, StyleService styleService) {
        this.transformerService = transformerService;
        this.styleService = styleService;
    }

    @SneakyThrows
    public byte[] generateResumePDF(Resume resume) {
        ByteArrayOutputStream htmlContent = transformerService.transform(resume, styleService);
        ByteArrayOutputStream pdfContent = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlContent.toString(), pdfContent);
        return pdfContent.toByteArray();
    }
}
