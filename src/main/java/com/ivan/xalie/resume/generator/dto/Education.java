package com.ivan.xalie.resume.generator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonTypeName("education")
public class Education {

    private String name;

    private String institution;

    @JsonProperty("graduation_date")
    private String graduationDate;

    private ContactInformation contact;
}
