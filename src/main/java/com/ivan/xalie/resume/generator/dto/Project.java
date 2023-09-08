package com.ivan.xalie.resume.generator.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonTypeName("project")
public class Project {
    private String name;
    private String context;
    private List<String> steps;
}
