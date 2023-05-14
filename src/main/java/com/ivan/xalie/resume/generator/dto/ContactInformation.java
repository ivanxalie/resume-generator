package com.ivan.xalie.resume.generator.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Address.class, name = "address"),
        @JsonSubTypes.Type(value = Icon.class, name = "icon")
})
@XmlRootElement
@XmlSeeAlso({Address.class, Icon.class})
public class ContactInformation {
}