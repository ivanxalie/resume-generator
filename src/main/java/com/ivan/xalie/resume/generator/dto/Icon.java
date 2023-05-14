package com.ivan.xalie.resume.generator.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ivan.xalie.resume.generator.deserializers.IconDeserializer;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonDeserialize(using = IconDeserializer.class)
public class Icon extends ContactInformation {
    private String iconSrc;
    private String link;
}
