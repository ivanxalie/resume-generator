package com.ivan.xalie.resume.generator.service.model;

import com.ivan.xalie.resume.generator.dto.Resume;

import java.io.ByteArrayOutputStream;

public interface ResumeToHtmlTransformerService {
    ByteArrayOutputStream transform(Resume resume, StyleService styleService);
}
