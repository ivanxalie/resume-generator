package com.ivan.xalie.resume.generator.controller;

import com.ivan.xalie.resume.generator.dto.Resume;
import com.ivan.xalie.resume.generator.service.model.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/resume")
@AllArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @PostMapping(value = "/generate-pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Mono<ResponseEntity<byte[]>> submitResume(@RequestBody Mono<Resume> resumeDTO) {
        return resumeDTO
                .flatMap(resume -> Mono.just(resumeService.generateResumePDF(resume)))
                .flatMap(pdfContent -> Mono.just(ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"resume.pdf\"")
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(pdfContent)))
                .onErrorResume(error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }
}
