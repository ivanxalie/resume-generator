package com.ivan.xalie.resume.generator.service.model;

import com.ivan.xalie.resume.generator.dto.Resume;

public interface ResumeService {
    public byte[] generateResumePDF(Resume resume);
}
