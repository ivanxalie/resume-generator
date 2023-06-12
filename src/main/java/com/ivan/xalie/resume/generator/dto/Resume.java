package com.ivan.xalie.resume.generator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonTypeName("resume")
@XmlRootElement(name = "resume")
@XmlType(propOrder = {
        "name",
        "positionTitle",
        "contactInformation",
        "professionalSummary",
        "languages",
        "workExperience",
        "education",
        "skills",
        "certifications",
        "awards",
        "professionalMemberships"
}
)
public class Resume {

    @JsonProperty

    private String name;

    @JsonProperty("position_title")
    private String positionTitle;

    @JsonProperty("contact_information")
    @Getter(onMethod_ = {@XmlElementWrapper(name = "contactInformation"), @XmlElement(name = "contact")})
    private List<ContactInformation> contactInformation;

    @JsonProperty("professional_summary")
    private String professionalSummary;

    @JsonProperty("languages")
    @Getter(onMethod_ = {@XmlElementWrapper(name = "languages"), @XmlElement(name = "language")})
    private List<Language> languages;

    @JsonProperty("work_experience")
    @Getter(onMethod_ = {@XmlElementWrapper(name = "workExperience"), @XmlElement(name = "job")})
    private List<WorkExperience> workExperience;

    @JsonProperty("education")
    @Getter(onMethod_ = {@XmlElementWrapper(name = "education"), @XmlElement(name = "degree")})
    private List<Education> education;

    @Getter(onMethod_ = {@XmlElementWrapper(name = "skills"), @XmlElement(name = "skill")})
    private List<String> skills;

    @Getter(onMethod_ = {@XmlElementWrapper(name = "certifications"), @XmlElement(name = "certification")})
    private List<String> certifications;

    @Getter(onMethod_ = {@XmlElementWrapper(name = "awards"), @XmlElement(name = "award")})
    private List<String> awards;


    private List<String> professionalMemberships;

    @JsonProperty("styles")
    @Getter(onMethod_ = {@XmlTransient})
    private List<CssSelector> styles;
}
