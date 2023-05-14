package com.ivan.xalie.resume.generator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ivan.xalie.resume.generator.dto.Resume;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.io.IOException;

@Profile("qa")
public class QaConfig {
    public static final String QA_RESUME = "qa-resume";

    public static final String TEST_ACROBAT_PATH_EXPRESSION = "${test.acrobat.path}";

    public static final String TEST_RESUME_DATA_PATH_EXPRESSION = "${test.resume.data.path}";

    @Bean(QA_RESUME)
    Resume resume(ObjectMapper mapper, @Value(TEST_RESUME_DATA_PATH_EXPRESSION) File file) throws IOException {
        ObjectReader reader = mapper.readerFor(Resume.class);
        return reader.readValue(file, Resume.class);
    }
}
