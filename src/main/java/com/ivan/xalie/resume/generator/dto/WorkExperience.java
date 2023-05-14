package com.ivan.xalie.resume.generator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonTypeName("work_experience")
public class WorkExperience {

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("contact")
    private ContactInformation contact;

    @JsonProperty("dates_of_employment")
    private String datesOfEmployment;

    @JsonProperty("job_duties")
    @Getter(onMethod_ = {@XmlElementWrapper(name = "jobDuties"), @XmlElement(name = "duty")})
    private List<String> jobDuties;

    @Getter(onMethod_ = {@XmlElementWrapper(name = "accomplishments"), @XmlElement(name = "accomplishment")})
    private List<String> accomplishments;

}
