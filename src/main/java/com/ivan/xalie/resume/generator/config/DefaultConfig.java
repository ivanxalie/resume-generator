package com.ivan.xalie.resume.generator.config;

import com.ivan.xalie.resume.generator.service.impl.ResumeServiceImpl;
import com.ivan.xalie.resume.generator.service.impl.ResumeToHtmlTransformerServiceImpl;
import com.ivan.xalie.resume.generator.service.impl.StyleServiceImpl;
import com.ivan.xalie.resume.generator.service.model.ResumeService;
import com.ivan.xalie.resume.generator.service.model.ResumeToHtmlTransformerService;
import com.ivan.xalie.resume.generator.service.model.StyleService;
import jakarta.xml.bind.Marshaller;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.transform.Templates;

@Configuration
public class DefaultConfig {

    @Bean
    @ConditionalOnMissingBean
    ResumeService resumeService(ResumeToHtmlTransformerService transformerService, StyleService styleService) {
        return new ResumeServiceImpl(transformerService, styleService);
    }

    @Bean
    @ConditionalOnMissingBean
    ResumeToHtmlTransformerService resumeToHtmlTransformerService(Marshaller marshaller, Templates templates) {
        return new ResumeToHtmlTransformerServiceImpl(marshaller, templates);
    }

    @Bean
    @ConditionalOnMissingBean
    StyleService styleService() {
        return new StyleServiceImpl();
    }
}
