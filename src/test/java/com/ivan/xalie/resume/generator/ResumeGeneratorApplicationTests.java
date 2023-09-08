package com.ivan.xalie.resume.generator;

import com.ivan.xalie.resume.generator.config.QaConfig;
import com.ivan.xalie.resume.generator.dto.Resume;
import com.ivan.xalie.resume.generator.service.model.ResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("qa")
@ImportAutoConfiguration(QaConfig.class)
class ResumeGeneratorApplicationTests {

    @Autowired
    ResumeService resumeService;

    @Value(QaConfig.TEST_ACROBAT_PATH_EXPRESSION)
    private String acrobatPath;

    @Autowired
    @Qualifier(QaConfig.QA_RESUME)
    private Resume resume;

    @Test
    void contextLoads() {
        assertThat(resumeService).isNotNull();
        assertThat(acrobatPath).isNotNull();
        assertThat(resume).isNotNull();
    }

    @Test
    void testResumeGenerate() throws IOException {
        byte[] result = resumeService.generateResumePDF(resume);

        Path tmpDest = Paths.get(System.getProperty("java.io.tmpdir"), UUID.randomUUID() + ".pdf");
        Path pdf = Files.write(tmpDest, Objects.requireNonNull(result));

        open(pdf);
    }

    private void open(Path pdf) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("\"" + acrobatPath + "\" \"" + pdf + "\"");
        builder.redirectErrorStream(true);
        builder.start();
    }
}
