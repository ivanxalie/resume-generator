package com.ivan.xalie.resume.generator.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeyValue extends ContactInformation {
    private String key;
    private String value;
}
