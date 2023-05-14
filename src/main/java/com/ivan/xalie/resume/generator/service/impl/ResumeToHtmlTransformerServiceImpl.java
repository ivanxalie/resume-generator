package com.ivan.xalie.resume.generator.service.impl;

import com.ivan.xalie.resume.generator.dto.Resume;
import com.ivan.xalie.resume.generator.service.model.ResumeToHtmlTransformerService;
import com.ivan.xalie.resume.generator.service.model.StyleService;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static com.ivan.xalie.resume.generator.config.JaxbAppConfig.RESUME_MARSHALLER;
import static com.ivan.xalie.resume.generator.config.JaxbAppConfig.RESUME_TEMPLATE;

public class ResumeToHtmlTransformerServiceImpl implements ResumeToHtmlTransformerService {
    private final Marshaller marshaller;
    private final Templates template;

    public ResumeToHtmlTransformerServiceImpl(@Qualifier(RESUME_MARSHALLER) Marshaller marshaller,
                                              @Qualifier(RESUME_TEMPLATE) Templates template) {
        this.marshaller = marshaller;
        this.template = template;
    }

    @Override
    @SneakyThrows
    public ByteArrayOutputStream transform(Resume resume, StyleService styleService) {
        ByteArrayOutputStream resumeStream = new ByteArrayOutputStream();
        marshaller.marshal(resume, resumeStream);
        Transformer transformer = template.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "html");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setParameter("css", styleService.transform(resume.getStyles()));
        Source xmlSource = new StreamSource(new ByteArrayInputStream(resumeStream.toByteArray()));

        ByteArrayOutputStream htmlContent = new ByteArrayOutputStream();
        StreamResult html = new StreamResult(htmlContent);
        transformer.transform(xmlSource, html);
        return htmlContent;
    }
}
