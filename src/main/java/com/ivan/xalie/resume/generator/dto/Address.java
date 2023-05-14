package com.ivan.xalie.resume.generator.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends ContactInformation {
    private String location;
}
