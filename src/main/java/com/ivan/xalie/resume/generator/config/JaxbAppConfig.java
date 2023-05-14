package com.ivan.xalie.resume.generator.config;

import com.ivan.xalie.resume.generator.dto.Resume;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class JaxbAppConfig {
    public static final String JAXB_RESUME_CONTEXT = "jaxb-resume-context";
    public static final String RESUME_MARSHALLER = "jaxb-resume-marshaller";
    public static final String RESUME_TEMPLATE = "xslt-resume-template";

    public static final String TEMPLATE_LOCATION_EXPRESSION = "${template.location}";

    @Bean(JAXB_RESUME_CONTEXT)
    public JAXBContext resumeContext() throws JAXBException {
        return JAXBContext.newInstance(Resume.class);
    }

    @Bean(RESUME_MARSHALLER)
    public Marshaller resumeMarshaller(@Qualifier(JAXB_RESUME_CONTEXT) JAXBContext context) throws JAXBException {
        return context.createMarshaller();
    }

    @Bean(RESUME_TEMPLATE)
    public Templates template(@Value(TEMPLATE_LOCATION_EXPRESSION) Resource resource) throws IOException,
            TransformerConfigurationException {
        TransformerFactory factory = TransformerFactory.newInstance();
        return factory.newTemplates(new StreamSource(new FileReader(resource.getFile())));
    }
}
